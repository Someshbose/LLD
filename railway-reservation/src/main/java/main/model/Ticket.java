package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ticket {
  private int pnr;
  private List<UserDetails> userDetails;
  private static Scanner sc = new Scanner(System.in);

  public void reserve(int numbers) {
    userDetails = new ArrayList<UserDetails>();
    for (int i = 0; i < numbers; i++) {
      System.out.println("Give User details-");

      System.out.println("Enter name-");
      String name = sc.nextLine();

      System.out.println("Enter age-");
      int age = Integer.parseInt(sc.nextLine());

      System.out.println("Enter gender(M/F)-");
      String gender = sc.nextLine();
      Gender gen = Gender.valueOf(gender);

      System.out.println("Source (A-F)");
      String source = sc.nextLine();
      Source src = Source.valueOf(source);

      System.out.println("Destination (A-F)");
      String destination = sc.nextLine();
      Source dest = Source.valueOf(source);

      System.out.println("Berth preference (LB, MB, UB, SU, SL)");
      String berth = sc.nextLine();
      Berth_Preference berth_pref = Berth_Preference.valueOf(berth);

      UserDetails user = new UserDetails(name, age, gen, src, dest, berth_pref);
      userDetails.add(user);
    }

  }

  public void setPnr(int number) {
    this.pnr = number;
  }

  public int getPnr() {
    return pnr;
  }
}
