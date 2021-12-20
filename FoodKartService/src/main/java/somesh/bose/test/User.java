package somesh.bose.test;

import java.util.ArrayList;
import java.util.List;

public class User {
  private Long userId;
  private String name;
  private String contact;
  private String pinCode;

  private List<Order> orderHistory;


  public User(Long userId, String name,String contact,String pincode){
    this.userId = userId;
    this.name=name;
    this.contact=contact;
    this.pinCode=pincode;
    orderHistory = new ArrayList<>();
  }

  public Long getUserId() {
    return userId;
  }

  public String getContact() {
    return contact;
  }

  public String getName() {
    return name;
  }

  public String getPinCode() {
    return pinCode;
  }

  public List<Order> getOrderHistory() {
    return orderHistory;
  }
}
