package main.model;

public class InviteNotifcation {
  private int eventId;
  private Response response;

  public InviteNotifcation(int eventId,Response response){
    this.eventId =eventId;
    this.response =response;
  }

  public int getEventId() {
    return eventId;
  }

  public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }
}
