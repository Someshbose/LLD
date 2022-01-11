package main;
import java.util.ArrayList;
import java.util.List;
import main.model.ExpenseMetadata;
import main.model.ExpenseType;
import main.model.Split;
import main.model.User;
import main.service.SplitWise;

public class Driver {

  public static void main(String[] args) {
    SplitWise splitWise = SplitWise.getInstance();

    splitWise.addUser(new User("Somesh","9338226745"));
    splitWise.addUser(new User("Harsh","9338226740"));
    splitWise.addUser(new User("Sasank","9338226743"));

    splitWise.showBalance();
    List<Split> list = new ArrayList<>();
    list.add(new Split("9338226740",50));
    list.add(new Split("9338226745",50));
    list.add(new Split("9338226745",50));
    splitWise.addExpense(ExpenseType.EXACT,1000,"9338226745",list,new ExpenseMetadata("Chaat",null));

    splitWise.showBalance("9338226743");
  }
}
