package main.model;

public class User {
  String name;
  String contact;
  double share;

  public User(String name, String contact){
    this.name=name;
    this.contact=contact;
    this.share=0.0;
  }

  boolean addShare(double amnt){
    this.share += amnt;
    return  true;
  }

  public String getContact() {
    return contact;
  }

  public String getName() {
    return name;
  }
}
