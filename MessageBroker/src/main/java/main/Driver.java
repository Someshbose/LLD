package main;

import main.handlers.ConsumerWorker;
import main.models.Consumer;
import main.models.ConsumerGroup;
import main.models.Message;
import main.models.Partition;
import main.models.Topic;
import main.publicinterface.MessageBroker;

public class Driver {

  public static void main(String[] args) {
    MessageBroker broker = MessageBroker.getInstance();

    // 1. Creating a Topic
    Topic topic = broker.createTopic("Topic1");

    // 2. Creating partitions in Topic
    Partition p1= broker.createPartition(topic,"P1");
    Partition p2= broker.createPartition(topic,"P2");
    Partition p3= broker.createPartition(topic,"P3");

    // 3. Create a consumerGroup
    ConsumerGroup consumerGroup= broker.createConsumerGroup("C_G1",3);

    // 4. Create multiple Consumers in a ConsumerGroup
    Consumer c1 = broker.createConsumer("C1",consumerGroup);
    Consumer c2 = broker.createConsumer("C2",consumerGroup);
    Consumer c3 = broker.createConsumer("C3",consumerGroup);

    // 5. Subscribe a consumer_group to a particular topic and partitions
    broker.subscribe(topic,p1,c1);
    broker.subscribe(topic,p2,c2);
    broker.subscribe(topic,p3,c3);

    // 6. publish message
    broker.publish(topic,p1,new Message("Hey"));
    broker.publish(topic,p2,new Message("Hola"));
    broker.publish(topic,p3,new Message("Namaste"));
    broker.publish(topic,p1,new Message("kitkat"));
    broker.publish(topic,p1,new Message("Me"));

    ConsumerWorker worker = new ConsumerWorker(topic,p1,c1);

    new Thread(worker).start();
//    new Thread(c1).start();
//    new Thread(c2).start();
//    new Thread(c3).start();
  }
}
