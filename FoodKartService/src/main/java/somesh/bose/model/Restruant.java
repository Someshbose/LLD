package somesh.bose.model;

import java.util.List;

public class Restruant {
  Long restruantId;
  String restruantName;
  List<String> servicablePincodes;
  String food_item;
  double price;
  int qty;
  double rating;
  List<Review> reviews;
  Long ownerId;

  public Restruant(Long id, String restruantName,List<String> pincodes,String foodItem,double price,int qty){
    this.restruantId=id;
    this.restruantName=restruantName;
    this.servicablePincodes=pincodes;
    this.food_item=foodItem;
    this.price=price;
    this.qty=qty;
  }

  public boolean setQuantity(int qty){
    this.qty = qty;
    return true;
  }

  public Long getRestruantId() {
    return restruantId;
  }

  public double getRating() {
    return rating;
  }

  public double getPrice() {
    return price;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  public String getRestruantName() {
    return restruantName;
  }

  public Long getOwnerId() {
    return ownerId;
  }

  public int getQty() {
    return qty;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }
}
