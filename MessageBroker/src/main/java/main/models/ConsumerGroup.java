package main.models;

import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;

public class ConsumerGroup {
  private final String consumerGroupName;
  List<Consumer> consumerList;

  public ConsumerGroup(String consumerGroupName,int numConsumer){
    this.consumerGroupName = consumerGroupName;
    this.consumerList = new ArrayList<Consumer>(numConsumer);
  }

  public void addConsumer(@NonNull final String consumerName){
    Consumer consumer = new Consumer(consumerName);
    consumerList.add(consumer);
  }

  public void addConsumer(@NonNull final Consumer consumer){
    consumerList.add(consumer);
  }

}
