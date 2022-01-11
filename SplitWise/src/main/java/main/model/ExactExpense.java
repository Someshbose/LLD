package main.model;

import java.util.List;

public class ExactExpense extends Expense{

  public ExactExpense( double amount, String payer,
      List<Split> splits, ExpenseMetadata metadata) {
    super(IdGenerator.getId(), amount, metadata, payer, splits);
    this.type= ExpenseType.EXACT;
  }

  @Override
  public boolean validate() {
    double totalAmount = getAmount();
    double sumSplitAmount = 0;
    for(Split split : getSplits()) {
      //ExactSplit exactSplit = (ExactSplit) split;
      sumSplitAmount += split.getAmount();
    }

    if (totalAmount != sumSplitAmount) {
      return false;
    }
    return true;
  }
}
