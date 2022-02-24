package main.service;

public class IdGeneratorService {

  static  private  int id = 100;

  public static int getId() {
    return id++;
  }
}
