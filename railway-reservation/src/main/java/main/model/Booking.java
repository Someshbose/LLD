package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Booking {
  private static Scanner sc = new Scanner(System.in);
  private List<Train> trains;

  public Booking() {
    trains = new ArrayList<Train>();
    Train t1 = new Train(123);
    trains.add(t1);
  }

  public void book() {
    System.out.println("How many tickets you want to book?");
    int numberTicket = Integer.parseInt(sc.nextLine());

    int pnr_details = trains.get(0).reserve(numberTicket);

    System.out.println("PNR number is-" + pnr_details);

  }
}
