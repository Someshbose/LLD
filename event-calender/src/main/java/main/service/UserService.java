package main.service;

import main.model.*;

import java.util.*;

public class UserService {

  EventService eventService =null;
  User loggeIn = null;
  Map<String,User> userMap;

  static UserService userService = null;

  static public UserService getInstance(){
    if (userService == null){
      userService = new UserService();
    }
    return userService;
  }

  private UserService(){
    userMap = new HashMap<>();
    eventService=EventService.getInstance();
  }

  public void addUser(User user){
    userMap.put(user.getName(),user);
  }

  public boolean loggedIn(String name){

    if (userMap.containsKey(name)){
      loggeIn =  userMap.get(name);
    }
    return false;
  }

  public Event createEvent( Date start ,Date end, List<User> users,String title, Location location){
    if(loggeIn!=null && eventService.checkAvailability(start,end)){
      return eventService.createEvent( start,end, loggeIn, users, title,location);
    }
    else
      return null;
  }

//  boolean updateEvent(...){
//    service.updateEvent(..);
//  }

  public List<Event> getEvents(Date start, Date end){
    List<Event> results = new ArrayList<>();
    for(InviteNotifcation notifcation :loggeIn.getList()){
      if (notifcation.getResponse() == Response.ACCEPT)
        results.addAll(eventService.search(notifcation.getEventId(), start,end));
    }
    return  results;
  }
}
