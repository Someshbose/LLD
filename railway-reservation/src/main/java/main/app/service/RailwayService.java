package main.app.service;

public interface RailwayService {
  void book();

  String cancel();

  String printDetials(int pnr);

  String availability();
}
