package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService extends  User{

  EventService service;

  public UserService(){
    super("Manish");
    service = EventService.getInstance();
  }
  Event createEvent( Date start ,Date end, List<User> users, String title,Location location){
    if(service.checkAvailability(start,end)){
      return service.createEvent( start,end, this, users, title,location);
    }
    else
      return null;
  }

//  boolean updateEvent(...){
//    service.updateEvent(..);
//  }

  List<Event> getEvents(Date start,Date end){
    List<Event> results = new ArrayList<>();
    for(InviteNotifcation notifcation :list){
      if (notifcation.response == Response.ACCEPT)
        results.addAll(service.search(notifcation.getEventId(), start,end));
    }
    return  results;
  }
}
