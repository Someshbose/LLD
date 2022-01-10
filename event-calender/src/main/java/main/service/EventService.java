package main.service;

import main.model.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventService {

  private Map<Integer, Event> eventMap;
  //private Map<Integer, Location> locationMap;
  //private List<Location> locations;
  //HashMap<[Date date,int duration]>

  static EventService service=null;



  static EventService getInstance(){
      if(service ==null){
        service = new EventService();
      }
      return service;
  }

  private EventService(){
    eventMap = new HashMap<>();
    //locationMap = new HashMap<>();
    //locations = new ArrayList<>();
  }

  public boolean checkAvailability(Date start, Date end){
    for(Map.Entry entry:eventMap.entrySet()){
      Event event = (Event)entry.getValue();
      if (start.after(event.getStart()) && end.before(event.getEnd()) ||
          event.getStart().after(start) && event.getEnd().before(end)){
        return false;
      }
    }
    return true;
  }

  Event createEvent(Date start, Date end, User user, List<User> users, String title, Location location){
    Event event = new Event(title, start,end,location,user,users);
    eventMap.put(event.getId(), event);
    for(User temp : users)
      pushNotification(temp,event);
    return event ;
  }

  private  void pushNotification(User user, Event event){
    user.getList().add(new InviteNotifcation(event.getId(), Response.ACCEPT));
  }

  public List<Event> search(int id, Date start, Date end){
    ArrayList<Event> result = new ArrayList<>();

    for(Map.Entry entry: eventMap.entrySet()){
      Event event = (Event)entry.getValue();
      if(event.getId()== id ){
        continue;
      }
      if ((start.after(event.getStart()) && end.before(event.getEnd()) ||
          event.getStart().after(start) && event.getEnd().before(end))){
          result.add(event);
      }
    }
    return result;
  }

}
