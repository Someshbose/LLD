package main.model;

public class Split {
  String user;
  double amount;

  public Split(String user, double amount){
    this.user = user;
    this.amount = amount;
  }

  public String getUser() {
    return user;
  }

  public double getAmount() {
    return amount;
  }
}
