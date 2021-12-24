package main.board;

public class Board {
  Base[] bases = new Base[4];

  static int turn =0;

  Board(){
    bases[0] = new Base(Color.YELLOW);
    bases[1] = new Base(Color.RED);
    bases[2] = new Base(Color.BLUE);
    bases[3] = new Base(Color.GREEN);
  }

  void playTurn(){
    turn = turn %4;

    int diceAmnt = Dice.rollDice();

    if(diceAmnt == 6){
      System.out.println("Choose options");
    }

    bases[turn].move();
  }


}
