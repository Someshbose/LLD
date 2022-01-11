package model;

import java.util.Date;
import java.util.List;

public class Booking {
  String bookingId;
  Room room;
  Person person;
  Date bookingDate;
  Date checkInDate;
  int duration;
  List<Person> guests;
  PaymentStatus paymentStatus;
  PaymentType type;
  Payment amount;
}
