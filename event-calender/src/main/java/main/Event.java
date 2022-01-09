package main;

import java.util.Date;
import java.util.List;

public class Event {
  int id;
  String eventName;
  Date start;
  Date end;
  Location location;
  User owner;
  List<User> invitees;

  public Event(String name,Date start, Date end,Location location,User owner,List<User> invitees){
    this.id= IdGenerator.getId();
    this.start =start;
    this.end=end;
    this.location =location;
    this.owner=owner;
    this.invitees =invitees;
  }

  public Date getEnd() {
    return end;
  }

  public Date getStart() {
    return start;
  }

  public int getId() {
    return id;
  }
}
