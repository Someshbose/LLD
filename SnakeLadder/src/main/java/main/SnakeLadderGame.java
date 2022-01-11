package main;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadderGame {

  public static void main(String[] args) {

    List<Snakes> snakes = new ArrayList<>();
    snakes.add(new Snakes(99,60));
    snakes.add(new Snakes(98,80));


    List<Player> players = new ArrayList<>();
    players.add(new Player("Somesh"));
    players.add(new Player("Puja"));
    Board board=new Board(snakes,new ArrayList<>(),players);
    while (board.gameStatus!=GameStatus.WIN){
      board.start();
    }
  }
}
