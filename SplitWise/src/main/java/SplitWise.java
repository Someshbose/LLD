package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.model.Expense;
import main.model.ExpenseMetadata;
import main.model.ExpenseType;
import main.model.Split;
import main.model.User;

public class SplitWise {
  private HashMap<String, User> userMap;
  private HashMap<String, Map<String,Double>> balanceSheet;
  private List<Expense> expensesHistory;
  private ExpenseService service;

  static SplitWise splitWise =null;
  private SplitWise(){
    userMap= new HashMap<>();
    expensesHistory = new ArrayList<>();
    balanceSheet =new HashMap<>();
    service = ExpenseService.getInstance();
  }

  static SplitWise getInstance(){
    if(splitWise == null)
      splitWise = new SplitWise();

    return splitWise;
  }


  boolean addUser(User user){
    if (userMap.containsKey(user.getContact()))
      return false;

    userMap.put(user.getContact(),user);
    balanceSheet.put(user.getContact(), new HashMap<>());
    return true;
  }

  public boolean addExpense(ExpenseType type, double amnt, String paidBy, List<Split> splits, ExpenseMetadata metadata){
    Expense expense = service.createExpense(type,amnt,paidBy,splits,metadata);
    expensesHistory.add(expense);
    for(Split split : expense.getSplits()) {
      String paidTo = split.getUser();
      Map<String, Double> balances = balanceSheet.get(paidBy);
      balances.put(paidTo, balances.getOrDefault(paidTo, 0.0) + split.getAmount());
      balances = balanceSheet.get(paidTo);
      balances.put(paidBy, balances.getOrDefault(paidBy, 0.0) - split.getAmount());
    }
    return true;
  }

  public void showBalance(){
    boolean isEmpty = true;
    for(Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
      for(Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
        if (userBalance.getValue() != 0)
          isEmpty = false;
        printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
      }
    }
    if (isEmpty) {
      System.out.println("No Balance to show");
    }
  }

  private void printBalance(String user1, String user2, Double amount) {
    String user1Name = userMap.get(user1).getName();
    String user2Name = userMap.get(user2).getName();
    if (amount > 0) {
      System.out.println(user2Name + " owes " + user1Name + " : " + Math.abs(amount));
    } else if (amount < 0) {
      System.out.println(user1Name + " owes " + user2Name + " : " + Math.abs(amount));
    }
  }

  public void showBalance(String contact) {
    boolean isEmpty = true;
    Map<String, Double> userBalance = balanceSheet.get(contact);
    for(Map.Entry<String, Double> individualBalance : userBalance.entrySet()) {
      if (individualBalance.getValue() != 0)
        isEmpty = false;
      printBalance(contact, individualBalance.getKey(), individualBalance.getValue());
    }
    if (isEmpty) {
      System.out.println("No Balance to show for " + contact);
    }
  }
}
