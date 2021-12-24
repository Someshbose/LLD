package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
  List<Snakes> snakes = new ArrayList<>();
  List<Ladder> ladders = new ArrayList<>();
  List<Player> players  = new ArrayList<>();

  GameStatus gameStatus;
  HashMap<Integer, Integer> boardEntity=new HashMap<>();

  int GAME_END =100;
  static int turn =0;
  Board( List<Snakes> snakesList,List<Ladder> ladderList,List<Player> players){
    this.snakes.addAll(snakesList);
    this.ladders.addAll(ladderList);
    this.players.addAll(players);

    processBoard();
  }

  private void processBoard(){
    for(Snakes snake:snakes){
      boardEntity.put(snake.head,snake.tail);
    }

    for (Ladder ladder:ladders){
      boardEntity.put(ladder.head,ladder.tail);
    }
  }

  void start(){
    int player = turn++;
    turn = turn % players.size();

    int new_pos = players.get(player).pos+Dice.rollDice();
    if(new_pos<=GAME_END){

      if(new_pos == GAME_END){
        gameStatus = GameStatus.WIN;
        System.out.println(players.get(player).name+" won!!");
        return;
      }

      if(boardEntity.containsKey(new_pos)){
        new_pos = boardEntity.get(new_pos);
        System.out.println("badluck/goodluck");
      }

      players.get(player).pos = new_pos;
      System.out.println(players.get(player).name+" moved to"+players.get(player).pos);
    }
  }
}
