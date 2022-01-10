package main.models;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;
import lombok.NonNull;
import main.publicinterface.MessageBroker;

@Getter
public class Consumer implements Runnable {
  private final AtomicInteger offset;
  private final String consumerName;
  private final String consumerId;

  private String partitionName;
  private MessageBroker broker =MessageBroker.getInstance();
  private String topicName;

  public Consumer(String consumerName){
    this.offset = new AtomicInteger(0);
    this.consumerName = consumerName;
    this.consumerId= UUID.randomUUID().toString();

  }

  public void consume(Message message)throws InterruptedException{
    System.out.println("Message consumed by Consumer:"+consumerName);
    Thread.sleep(1000);
  }

  public void setPartitionName(@NonNull String partitionName) {
    this.partitionName = partitionName;
  }

  public void setTopicName(@NonNull String topicName) {
    this.topicName = topicName;
  }

  public void run() {
    int currentOffset = this.offset.get();
    Message message = broker.consume(topicName, partitionName,this);

    System.out.println("Message consumed successfully"+message.getMessage());

    if (message!=null){
      this.getOffset().compareAndSet(currentOffset,currentOffset+1);
    }
  }
}
