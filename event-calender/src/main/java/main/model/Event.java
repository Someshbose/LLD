package main.model;

import java.util.Date;
import java.util.List;

public class Event {
  private int id;
  private String eventName;
  private Date start;
  private Date end;
  private Location location;
  private User owner;
  private List<User> invitees;

  public Event(String name,Date start, Date end,Location location,User owner,List<User> invitees){
    this.id= IdGenerator.getId();
    this.eventName = name;
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
