package main;

import main.model.Event;
import main.model.Location;
import main.model.User;
import main.service.UserService;

import java.util.Arrays;
import java.util.Date;

public class Helper {
  public static void main(String[] args) {
    UserService userService = UserService.getInstance();

    User user = new User("Ravi");
    User user2 = new User("Naresh");

    userService.addUser(user);
    userService.addUser(user2);
    userService.loggedIn("Ravi");

    Event event = userService.createEvent(new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+130), Arrays.asList(new User[]{user2}),"Zoom ",new Location("Room 1"));
    Event event2 = userService.createEvent(new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+50), Arrays.asList(new User[]{user2}),"Zoom 2",new Location("Room 1"));


    System.out.println(event+" "+event2);

    //System.out.println(new Date(System.currentTimeMillis()-20));
    userService.loggedIn("Naresh");

    System.out.println(userService.getEvents(new Date(System.currentTimeMillis()-100), new Date(System.currentTimeMillis()+100)));
  }
}
