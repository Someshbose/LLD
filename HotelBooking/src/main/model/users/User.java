package main.model.users;

import java.util.List;
import main.model.Booking;
import main.model.Person;
import main.model.Room;
import main.model.dao.PaymentDetails;
import main.service.SearchIndex;

public class User extends Person {
  SearchIndex search;

  List<Room> searchRoom(){
    return null;
  }
  Booking bookRoom(){
    return null;
  }
  boolean cancelRoom(String roomId){
    return true;
  }
  boolean payBill(PaymentDetails details){
    return true;
  }

}
