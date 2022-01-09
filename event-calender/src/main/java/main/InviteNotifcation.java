package main;

public class InviteNotifcation {
  int eventId;
  Response response;

  public InviteNotifcation(int eventId,Response response){
    this.eventId =eventId;
    this.response =response;
  }

  public int getEventId() {
    return eventId;
  }

  public void setResponse(Response response) {
    this.response = response;
  }
}
