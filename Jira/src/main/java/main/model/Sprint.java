package main.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Sprint {

  int sprintId;
  String sprintName;
  List<Task> tasks;
  Date startDate;
  int duration;

  public Sprint(String sprintName, List<Task> tasks, int duration){
    this.sprintId = IdGenerator.getId();
    this.sprintName = sprintName;
    this.tasks = new ArrayList<>();
    if(tasks !=null)
      for (Task task:tasks){
        this.tasks.add(task);
      }
    this.duration = duration;

    this.startDate = new Date(System.currentTimeMillis());
  }

  public boolean addTask(Task task){
    tasks.add(task);
    return true;
  }

  public Map<TaskStatus,List<Task>> showBoard(){
    return tasks.stream().collect(Collectors.groupingBy(i->i.getStatus()));
  }

  boolean removeTask(int taskId){

    Optional<Task> task = getTask(taskId);
    if(task.isPresent()){
      tasks.remove(task.get());
      return true;
    }
    return false;
  }

  public Optional<Task> getTask(int taskId){
    return tasks.stream().filter(i->i.getTaskId() ==taskId).findFirst();
  }
}
