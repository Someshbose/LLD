package main.handlers;

import lombok.NonNull;
import lombok.SneakyThrows;
import main.models.Consumer;
import main.models.Message;
import main.models.Partition;
import main.models.Topic;

public class ConsumerWorker implements Runnable{
  private final Topic topic;
  private final Partition partition;
  private final Consumer consumer;

  public ConsumerWorker(@NonNull final Topic topic, @NonNull final Partition partition,@NonNull final Consumer consumer){
    this.topic = topic;
    this.partition = partition;
    this.consumer =consumer;
  }

  @SneakyThrows
  public void run() {// C1 || C2 || C3
    synchronized (consumer) {
      do {

        int currentOffset = consumer.getOffset().get();
        while (currentOffset >= partition.getMessageList().size()) {
          consumer.wait();
        }

        Message message = partition.getMessageList().get(currentOffset);
        consumer.consume(message);

        // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
        // consuming we need to increase only if it was previous one.
        consumer.getOffset().compareAndSet(currentOffset, currentOffset + 1);
      } while (true);
    }
  }

  synchronized public void wakeUpIfNeeded() {
    synchronized (consumer) {
      consumer.notify();
    }
  }

}
