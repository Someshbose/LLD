package main;

import java.util.Arrays;
import java.util.Date;

public class Helper {
  public static void main(String[] args) {
    UserService userService = new UserService();
    User user = new User("Ravi");
    User user2 = new User("Naresh");

    Event event = userService.createEvent(new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+30), Arrays.asList(new User[]{user,user2}),"Zoom ",new Location("Room 1"));
    System.out.println(event.getId()+ ""+ event.getStart());

    System.out.println(new Date(System.currentTimeMillis()-20));

    System.out.println(userService.getEvents(new Date(System.currentTimeMillis()-10), new Date(System.currentTimeMillis())));
  }
}
