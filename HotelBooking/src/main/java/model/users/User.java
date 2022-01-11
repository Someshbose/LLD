package model.users;

import java.util.List;
import model.Booking;
import model.Person;
import model.Room;
import model.dao.PaymentDetails;
import service.SearchIndex;

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
