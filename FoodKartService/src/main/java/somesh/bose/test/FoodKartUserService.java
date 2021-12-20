package somesh.bose.test;

import java.util.HashMap;

public class FoodKartUserService {
  private static FoodKartUserService foodKartUserService=null;

  HashMap<Long,User>  userHashMap;
  HashMap<String,Long>  phnHashMap;

  private FoodKartUserService(){
    userHashMap = new HashMap<>();
    phnHashMap = new HashMap<>();
  };

  public static FoodKartUserService getInstance(){
    if(foodKartUserService==null){
      foodKartUserService=new FoodKartUserService();
    }
    return foodKartUserService;
  }

  public User registerUser(String name,String contact,String pinCode){
    if(phnHashMap.containsKey(contact)){
      //UserAlreadyExistException
      System.out.println(userHashMap.get(phnHashMap.get(contact)).getName()+ "user already exist with given contact Number");
      return null;
    }
    User user = new User(IdGenerator.getId(),name,contact,pinCode);
    phnHashMap.put(user.getContact(),user.getUserId());
    userHashMap.put(user.getUserId(),user);

    return user;
  }

  User getUser(String phn){
    return userHashMap.getOrDefault(phnHashMap.getOrDefault(phn,null),null);
  }


}
