package somesh.bose.model;

public class Order {
  long orderId;
  long restruantId;
  long userId;
  //Date orderPlacedAt;
  int qty;
  double price;

  public Order(Long id, long restruantId, long userId, int qty, double price){
    this.orderId =id;
    this.restruantId =restruantId;
    this.userId=userId;
    this.qty=qty;
    this.price=price;
  }
}
