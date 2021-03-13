package main;

import java.util.Scanner;

import com.google.inject.Guice;
import com.google.inject.Injector;
import main.app.service.RailwayService;
import main.config.RailwayReservationAppModule;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new RailwayReservationAppModule());
    RailwayService service =injector.getInstance(RailwayService.class);

    //Services service =new ServiceImpl();
    System.out.println("Welcome to Railway reservation system..");
    int option =-1;
    do{
      System.out.println("1. Book a ticket");
      System.out.println("2. PNR status");
      System.out.println("3. Cancel ticket");
      System.out.println("4. Add train");
      System.out.println("5. Exit");
      option = sc.nextInt();
      switch(option) {
        case 1: service.book();break;
        case 2: service.availability();break;
        case 3: service.cancel();break;
        case 4: break;
        case 5: break;
        default: System.out.println("Given a invalid Input");
      }
    }while(option!=5);
  }
}
