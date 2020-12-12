package main.model;

import java.util.ArrayList;
import java.util.List;

public class Train {
  private int train_id;
  private final int berth = 63;
  private final int RAC = 18;
  private final int waitingList = 10;

  private int available_berth;
  private int available_rac;

  private List<Ticket> ticketDetials;

  static private int ticket_number = 1000;
  private int booked;

  public Train(int id) {
    train_id = id;
    available_berth = berth;
    available_rac = RAC;
    booked = 0;
    ticketDetials = new ArrayList<Ticket>();
  }

  public int reserve(int numbers) {
    /*if (available_berth >= numbers) {
      available_berth -= numbers;
      booked = numbers;

    } else if (available_berth != 0 && available_berth < numbers) {
      System.out.println("No of available berth is" + available_berth);
      int temp = numbers - available_berth;
      System.out.println("Booking confirmed for" + temp + "tickets.");
      available_berth = 0;

    }
*/
    Ticket ticket = new Ticket();
    ticket.setPnr(ticket_number++);
    ticket.reserve(numbers);
    ticketDetials.add(ticket);

    return ticket.getPnr();
  }

}
