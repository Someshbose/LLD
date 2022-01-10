package main.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class Partition {
  private final String partitionName;
  private final List<Message> messageList;
  private final String partitionId;
  private final String partitionKey;
  private final List<Consumer> comsumerList;

  public Partition(@NonNull final String partitionName){
    this.partitionName = partitionName;
    this.messageList = new ArrayList<Message>();
    this.partitionId = UUID.randomUUID().toString();
    this.partitionKey = null;
    this.comsumerList = new ArrayList<Consumer>();
  }

  public Partition(@NonNull final String partitionName, @NonNull final String partitionKey){
    this.partitionName = partitionName;
    this.messageList = new ArrayList<Message>();
    this.partitionId = UUID.randomUUID().toString();
    this.partitionKey = partitionKey;
    this.comsumerList = new ArrayList<Consumer>();
  }

  public void addMessage(@NonNull final Message message){
    this.messageList.add(message);
  }

  public void subscribe(@NonNull final Consumer comsumer){
    this.comsumerList.add(comsumer);
  }
}
