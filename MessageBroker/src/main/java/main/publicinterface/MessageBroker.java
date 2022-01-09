package main.publicinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import main.models.Consumer;
import main.models.ConsumerGroup;
import main.models.Message;
import main.models.Partition;
import main.models.Topic;

public class MessageBroker {
  private final List<Topic> topicList;

  private static MessageBroker messageBroker = null;

  public static MessageBroker getInstance(){
    if (messageBroker==null){
      messageBroker = new MessageBroker();
    }
    return messageBroker;
  }

  private MessageBroker(){
    this.topicList = new ArrayList<Topic>();
  }

  // 1. creating a Topic
  public Topic createTopic(@NonNull final String topicName){
    Topic topic = new Topic(topicName);
    topicList.add(topic);
    System.out.println("Created a new topic:"+topicName);
    return topic;
  }


  // 2. Creating a Partition in a TOPIC
  public Partition createPartition(@NonNull final Topic topic, @NonNull final String partionName){
    return topic.addPartition(partionName);
  }

  //  publish message.
  public void publish(@NonNull Topic topic, @NonNull Partition partition, @NonNull Message message){
    if (!topic.getPartitions().contains(partition)){
      topic.addPartition(partition.getPartitionName());
    }

    partition.addMessage(message);
    System.out.println("Message published successfully");

  }

  //
  public Message consume(@NonNull final String topicName,String partitionName, Consumer consumer){
//    Optional<Topic> topic = this.topicList.stream().filter(t->t.getTopicName().equals(topicName)).findFirst();
//
//    if(topic.isPresent()){
//      Partition partition = topic.get().findPartitionByName(partitionName);
//      return partition.getMessageList().get(consumer.getOffset().get());
//    }
//
//    return null;
    Topic topic = null;
    for (Topic t : this.topicList) {
      if (t.getTopicName().equals(topicName)) {
        topic = t;
        break;
      }
    }

    Partition partition = topic.findPartitionByName(partitionName);

    return partition.getMessageList().get((consumer.getOffset().get()));


  }

  //3. create a consumerGroup.
  public ConsumerGroup createConsumerGroup(@NonNull final String consumerGroupName, @NonNull final int numConsumers){
    ConsumerGroup group = new ConsumerGroup(consumerGroupName,numConsumers);
    System.out.println("ConsumerGroup created successfully:"+consumerGroupName);
    return group;
  }

  /**
   * 4. creating a consumer in a consumergroup.
   */
  public Consumer createConsumer(@NonNull String consumerName, @NonNull ConsumerGroup consumerGroup){
    Consumer consumer = new Consumer(consumerName);
    consumerGroup.addConsumer(consumer);
    System.out.println("New Consumer in ConsumerGroup created successfully:"+consumer.getConsumerName());
    return consumer;
  }

  /**
   * 5. subscribing a consumer to a particular topic and particular partition.
   */
  public void subscribe(@NonNull Topic topic,@NonNull Partition partition, @NonNull Consumer consumer){
   // this.topicList.stream().filter(t->t.getTopicName().equals(topic.getTopicName())).forEach(t->t.getPartitions().stream().filter(k->k.getPartitionName().equals(partition.getPartitionName())).forEach(k->k.subscribe(consumer)));
    if(topic.getPartitions().contains(partition)){
      partition.subscribe(consumer);
      consumer.setPartitionName(partition.getPartitionName());
      consumer.setTopicName(topic.getTopicName());
    }

  }

  /**
   * 6. reset offset.
   */
  public void resetOffset(){

  }
}
