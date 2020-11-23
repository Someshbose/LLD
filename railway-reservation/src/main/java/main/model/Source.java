package main.model;

public enum Source {
  A(0), B(10), C(30), D(35), E(50), F(90);

  private final int amount;

  Source(int amount) {
    this.amount = amount;
  }

  public int amount() {
    return amount;
  }
}
