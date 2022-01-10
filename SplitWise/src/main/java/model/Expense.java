package main.model;

import java.util.List;

public abstract class Expense {
  int expenseId;
  double amount;
  ExpenseMetadata metadata;
  String payer;
  List<Split> splits;
  ExpenseType type;

  public Expense(int expenseId,double amount, ExpenseMetadata metadata, String payer, List<Split> splits ){
    this.expenseId = expenseId;
    this.amount =amount;
    this.metadata=metadata;
    this.payer=payer;
    this.splits=splits;
  }

  public List<Split> getSplits() {
    return splits;
  }

  public abstract boolean validate();

  public double getAmount() {
    return amount;
  }
}
