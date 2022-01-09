package main.models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class Topic {
  String topicName;
  String topicId;
  HashSet<Partition> partitions;

  public Topic(String topicName){
    this.topicId= UUID.randomUUID().toString();
    this.topicName = topicName;
    this.partitions = new HashSet<Partition>();
  }

  public Partition addPartition(@NonNull final String partitionName){
    Partition partition = new Partition(partitionName);
    this.partitions.add(partition);
    return partition;
  }

  public Partition addPartitionWithPartitionKey(@NonNull String partitionName,@NonNull String partitionKey){
    Partition partition = new Partition(partitionName,partitionKey);
    this.partitions.add(partition);
    return partition;
  }

  public Partition findPartitionByName(String partitionName){
    Iterator<Partition> partitionIterator= partitions.iterator();
    while (partitionIterator.hasNext()){
      Partition partition = partitionIterator.next();
      if(partition.getPartitionName().equals(partitionName))
        return partition;
    }
    return null;
  }



}
