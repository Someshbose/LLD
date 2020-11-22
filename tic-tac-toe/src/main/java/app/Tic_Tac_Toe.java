package app;

import java.util.Scanner;

public class Tic_Tac_Toe {

  public static void main(String[] args) {
    System.out.println("Starting Tic-Tac-Toe, multiplayer game");
    Scanner sc = new Scanner(System.in);
    int[][] box = new int[3][3];
    int counter = 9;
    int mark = -1;
    int player = -1;
    boolean status = false;
    while (counter > 0) {
      if (counter % 2 == 1) {
        player = 1;
        mark = 1;
      } else {
        player = 2;
        mark = 2;
      }
      System.out.println("Hey Player" + player + "give your position(1-9)");
      int pos = sc.nextInt() - 1;
      if (pos < 0 && pos > 9) {
        System.out.println("Invalid retrying");
        continue;
      }
      if (box[pos / 3][pos % 3] == 0) {
        box[pos / 3][pos % 3] = mark;
      } else {
        System.out.println("Not a valid one, retrying");
        continue;
      }
      if (checkBingo(box, mark)) {
        System.out.println("Bingo! " + player + "wins");
        status = true;
        break;
      }

      show(box);
      counter--;
    }
    if (!status) {
      System.out.println("Position is drawed!");
    }

  }

  private static void show(int[][] box) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(box[i][j] + " ");
      }
      System.out.println();
    }

  }

  static boolean checkBingo(int[][] box, int mark) {

    for (int i = 0; i < 3; i++) {
      boolean status = true;
      for (int j = 0; j < 3; j++) {
        if (box[i][j] == mark && status) {

        } else {
          status = false;
        }
      }
      if (status)
        return status;
    }

    for (int i = 0; i < 3; i++) {
      boolean status = true;
      for (int j = 0; j < 3; j++) {
        if (box[j][i] == mark && status) {

        } else {
          status = false;
        }
      }
      if (status)
        return status;
    }

    if (box[0][0] == mark && box[1][1] == mark && box[2][2] == mark)
      return true;
    if (box[0][2] == mark && box[1][1] == mark && box[2][0] == mark)
      return true;

    return false;
  }
}
