package main.board;

public class Goti {
  int pos;
  Color color;
  GotiStatus gotiStatus;

  Goti(Color color){
    this.color =color;
    this.pos=-1;
    gotiStatus = GotiStatus.NEW;
  }

}
