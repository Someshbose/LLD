package main;

public class Dice {
  static int rollDice(){
    return 1+(int)(Math.random()*100)%5;
  }
}
