package main.model;

public class User {
  int userId;
  String name;
  String mailId;
  UserStatus status;

  User(String name, String mail, UserStatus status){
    this.userId = IdGenerator.getId();
    this.name = name;
    this.mailId = mail;
    this.status = status;
  }

  boolean updateUserStatus(UserStatus status){
    this.status = status;
    return true;
  }

  public UserStatus getStatus() {
    return status;
  }
}
