package somesh.bose;

import somesh.bose.model.Restruant;
import somesh.bose.model.User;
import somesh.bose.service.FoodKartSearchService;
import somesh.bose.service.FoodKartUserService;

import java.util.ArrayList;
import java.util.List;

public class Driver {
  public static void main(String[] args) {
    FoodKartUserService userService = FoodKartUserService.getInstance();

    FoodKartSearchService service = FoodKartSearchService.getInstance();
    User u1 = userService.registerUser("Pralove","phoneNumber-1", "HSR");

   // User u2 = userService.registerUser("Pralove","phoneNumber-1", "HSR");
   // User u3 = userService.registerUser("Pralove","phoneNumber-1", "HSR");
    service.login("phoneNumber-1");

    ArrayList<String> list = new ArrayList<>();
    list.add("BTM");
    list.add("HSR");

    Restruant restruant = service.registerRestruant("Food Court-1", list, "NI Thali", 100, 5);
    Restruant restruant2 = service.registerRestruant("Food Court-2", list, "N Thali", 99, 2);

    List<Restruant> list2 = service.getRestruantList("rating");
    for(Restruant rst:list2)
      System.out.println(rst.getRestruantName());
  }
}
