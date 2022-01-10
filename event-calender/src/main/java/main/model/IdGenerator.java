package main.model;

public class IdGenerator {
  private static int id =100;
  public static int getId(){
    return id++;
  }
}
