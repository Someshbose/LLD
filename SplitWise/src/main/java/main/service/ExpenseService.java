package main.service;

import java.util.List;
import main.model.ExactExpense;
import main.model.Expense;
import main.model.ExpenseMetadata;
import main.model.ExpenseType;
import main.model.Split;

public class ExpenseService {

  static  ExpenseService service =null;
  private ExpenseService(){ }
  static ExpenseService getInstance(){
    if(service == null)
      service = new ExpenseService();
    return service;
  }

  Expense createExpense(ExpenseType type, double amnt, String paidBy, List<Split> splits, ExpenseMetadata metadata){
    Expense expense = null;
    switch (type){
      case PERCENT: break;
      case EQUAL:
        //expense = new Expense();
        break;
      case EXACT: return new ExactExpense(amnt, paidBy, splits, metadata);
      default: return null;
    }
    return expense;
  }
}
