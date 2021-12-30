package main.service;

import main.model.Payment;

public class RoomService extends Payment {
  final double GST =7.5;
  Payment bill;

  RoomService(Payment payment){
    this.bill = payment;
  }

  boolean addAmount(double bill){
    this.bill.setAmount(this.bill.getAmount()+bill+ bill*GST);
    return true;
  }

}
