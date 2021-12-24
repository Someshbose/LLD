package main.board;

import java.util.Arrays;

public class Base {
  Goti[] gotis = new Goti[4];
  Color color;
  int src, dest, safe;

  Base(Color color){
    this.color = color;
    for(int i=0;i<4;i++)
      gotis[i]= new Goti(color);

    init();
  }

  private void init(){
    switch (color){
      case RED:
        src = 13;
        dest = 5;
        safe =0;
        break;
      case GREEN:
        src = 26;
        dest = 10;
        safe = 5;
        break;
      case BLUE:
        src = 39;
        dest = 15;
        safe =10;
        break;
      case YELLOW:
        src = 0;
        dest = 57;
        safe = 50;
        break;
    }
  }

  void move(int diceNum, int diceRoll){
    gotis[diceNum].pos+= diceRoll;
  }

  void generate(){
    Arrays.asList(gotis).parallelStream().filter(item-> item.gotiStatus==GotiStatus.NEW).findFirst().get().gotiStatus=GotiStatus.IN_GAME;
  }

}
