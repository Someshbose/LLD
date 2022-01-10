package main.model;

import java.util.Date;

public class ExpenseMetadata {
  String name;
  String description;
  Date expenseDate;

  public ExpenseMetadata(String name,String description){
    this.name=name;
    this.description =description;
    expenseDate = new Date(System.currentTimeMillis());
  }
}
