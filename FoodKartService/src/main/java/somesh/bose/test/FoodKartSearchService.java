package somesh.bose.test;

import java.util.*;
import java.util.stream.Collectors;

public class FoodKartSearchService implements Search{

  private static FoodKartSearchService foodKartSearchService=null;
  private FoodKartUserService userService;
  private  User loggedInUser;

   HashMap<String, List<Long>> restruantPinCodeMap;
   HashMap<Long, Restruant> restruantHashMap;
   HashMap<String,Long>  restruantNameMap;
  private FoodKartSearchService(){
    userService = FoodKartUserService.getInstance();
    restruantHashMap = new HashMap<>();
    restruantPinCodeMap = new HashMap<>();
    restruantNameMap = new HashMap<>();
  };

  public static FoodKartSearchService getInstance(){
    if(foodKartSearchService==null){
      foodKartSearchService=new FoodKartSearchService();
    }
    return foodKartSearchService;
  }


  Restruant registerRestruant(String restruantName, List<String> pincodes, String item,double price, int qty){
    Restruant restruant = new Restruant(IdGenerator.getId(),restruantName,pincodes,item,price,qty);

    for(String pin:pincodes){
      if(!restruantPinCodeMap.containsKey(pin)) {
        restruantPinCodeMap.put(pin, new ArrayList<>());
      }
      //System.out.println(restruant + "id->"+restruant.getRestruantId());
      //System.out.println(restruantPinCodeMap.get(pin).size());

      restruantPinCodeMap.get(pin).add(restruant.getRestruantId());
      //System.out.println(restruantPinCodeMap.get(pin).size());
    }


    restruantHashMap.put(restruant.getRestruantId(),restruant);
    restruant.setOwnerId(loggedInUser.getUserId());
    restruantNameMap.put(restruant.getRestruantName(),restruant.getRestruantId());
    return  restruant;
  }


  @Override public List<Restruant> getRestruantList(String filter) {
    if(!restruantPinCodeMap.containsKey(loggedInUser.getPinCode())){
      System.out.println("Restruant not servicable in this pincode");
      return null;
    }

    List<Long> restruants = restruantPinCodeMap.get(loggedInUser.getPinCode());

    List<Restruant> restruantList = restruants.stream().map(item->restruantHashMap.get(item)).collect(Collectors.toList());

    if("rating".equals(filter)){
      Collections.sort(restruantList, new Comparator<Restruant>() {
        @Override public int compare(Restruant o1, Restruant o2) {
          return (int)(o2.getRating() -o1.getRating())*100 ;
        }
      });

      return restruantList;
    }


    //default it sorts out based on price;
    Collections.sort(restruantList, new Comparator<Restruant>() {
      @Override public int compare(Restruant o1, Restruant o2) {
        return (int)(o1.getPrice() -o2.getPrice())*100 ;
      }
    });

    return restruantList;

  }

  public User login(String phn){
    loggedInUser = userService.getUser(phn);
    if(loggedInUser == null){
      System.out.println( "User doesn't exist");
    }
    return loggedInUser;
  }


  Order placeOrder(String restruantName, int qty) {
    if (restruantNameMap.containsKey(restruantName)) {

      if (restruantHashMap.get(restruantNameMap.get(restruantName)).getQty() == 0) {
        System.out.println("Order can't be placed as it is out of stock");
      } else {
        int amnt = restruantHashMap.get(restruantNameMap.get(restruantName)).getQty();
        restruantHashMap.get(restruantNameMap.get(restruantName)).setQuantity(amnt - qty);
        Order order =
            new Order(IdGenerator.getId(), restruantHashMap.get(restruantNameMap.get(restruantName)).getRestruantId(),
                loggedInUser.getUserId(), qty, qty * restruantHashMap.get(restruantNameMap.get(restruantName)).getPrice());

        loggedInUser.getOrderHistory().add(order);

        return order;
      }

    }else{
      System.out.println("restruant doesn't exist");
    }
    return null;
  }

  boolean updateQuantity(String restruantName,int qty){
      if(restruantNameMap.containsKey(restruantName) ){

        if(restruantHashMap.get(restruantNameMap.get(restruantName)).getOwnerId()==loggedInUser.getUserId())
        restruantHashMap.get(restruantNameMap.get(restruantName)).setQuantity(qty);
        return true;
      }else{
        System.out.println("Sorry user is not the owner");
      }
      return false;
  }


  boolean rateRestruant(String restruantName,int rating,String comment){
    if(restruantNameMap.containsKey(restruantName) ){

      if(restruantHashMap.get(restruantNameMap.get(restruantName)).getOwnerId()!=loggedInUser.getUserId()){
        Review review = new Review(loggedInUser.getUserId(),rating,comment);
        double curr = restruantHashMap.get(restruantNameMap.get(restruantName)).getRating();
        int curr_size = restruantHashMap.get(restruantNameMap.get(restruantName)).getReviews().size();
        restruantHashMap.get(restruantNameMap.get(restruantName)).setRating((curr+rating+0.0)/(curr_size+1));
        restruantHashMap.get(restruantNameMap.get(restruantName)).getReviews().add(review);
      return true;
      }else{
        System.out.println("Sorry user is the owner, he can't review");
      }
    }
    return false;

  }

}
