package main;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventService {

  HashMap<Integer,Event> eventMap;
  //HashMap<[Date date,int duration]>
  //event -- >
  // 1. do check and compare within all event dates
  // 2. better approach save all the dates so that comparision time will be less


  static EventService service=null;

  static EventService getInstance(){
      if(service ==null){
        service = new EventService();
      }
      return service;
  }

  private EventService(){
    eventMap = new HashMap<>();
  }

  //31 st Dec 11.00 - 11.15
  //1st Jan 11.45 - 12.15

  // 1st Jan 12.00  -1st 12.30

  public boolean checkAvailability(Date start,Date end){
    for(Map.Entry entry:eventMap.entrySet()){
      Event event = (Event)entry.getValue();
      if (start.after(event.getStart()) && end.before(event.getEnd()) ||
          event.getStart().after(start) && event.getEnd().before(end)){
        return false;
      }
    }

    return true;
  }

  Event createEvent( Date start,Date end, User user, List<User> users, String title,Location location){
    Event event = new Event(title, start,end,location,user,users);
    eventMap.put(event.getId(), event);
    for(User temp : users)
      pushNotification(temp,event);
    return event ;
  }

  private  void pushNotification(User user,Event event){
    user.getList().add(new InviteNotifcation(event.getId(),Response.ACCEPT));
  }

  public List<Event> search(int id, Date start,Date end){
    ArrayList<Event> result = new ArrayList<>();
    for(Map.Entry entry:eventMap.entrySet()){
      Event event = (Event)entry.getValue();
      if(event.getId()== id ){
        continue;
      }
      if ((start.after(event.getStart()) && end.before(event.getEnd()) ||
          event.getStart().after(event.getStart()) && event.getEnd().before(event.getStart()))){
          result.add(event);
      }
    }
    return result;
  }

}
