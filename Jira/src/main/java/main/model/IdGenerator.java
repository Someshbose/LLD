package main.model;

public class IdGenerator {
  static  int val = 1000;
  static int getId(){
    return val++;
  }
}
