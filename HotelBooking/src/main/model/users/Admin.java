package main.model.users;

import java.util.List;
import main.model.Room;
import main.model.dao.Guest;
import main.model.dao.RoomDetails;

public class Admin extends User{
  boolean addRoom(RoomDetails roomDetails){
    return true;
  }
  boolean modifyRoom(RoomDetails roomDetails){
    return true;
  }
  boolean removeRoom(Room room ){
    return true;
  }

  boolean checkIn(String bookingId, List<Guest> guestList){
    return true;
  }
  boolean checkOut(String bookingId, List<Guest> guestList){
    return true;
  }
}
