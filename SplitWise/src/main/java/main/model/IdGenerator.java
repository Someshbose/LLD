package main.model;

public class IdGenerator {
  static private int id=1000;

  public static int getId() {
    return id++;
  }
}
