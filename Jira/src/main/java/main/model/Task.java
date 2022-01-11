package main.model;

import java.util.ArrayList;
import java.util.List;

public class Task {
  int taskId;
  String taskName;
  String taskDescription;
  TaskType taskType;
  TaskStatus status;
  User assigned;
  List<TaskActivity> activities= new ArrayList<>();

  public Task(String taskName, String description, TaskType taskType, User assigned){
    this.taskId = IdGenerator.getId();
    this.taskName = taskName;
    this.taskDescription = description;
    this.taskType = taskType;
    this.assigned = assigned;
    this.status= TaskStatus.OPEN;

    activities.add(new TaskActivity("taskName"+taskName+"is created"));
  }

  boolean updateStatus(TaskStatus status){
    this.status = status;
    activities.add(new TaskActivity("taskName"+taskName+"is updated to"+status));
    return true;
  }

  boolean updateUser(User user){
    if (user.getStatus() == UserStatus.BLOCKED || user.getStatus() == UserStatus.DEACTIVE)
      return false;
    else {
      this.assigned = user;
      activities.add(new TaskActivity("taskName"+taskName+"is assigned to"+user.name));
      return true;
    }
  }

  public TaskStatus getStatus() {
    return status;
  }

  public int getTaskId() {
    return taskId;
  }

  public List<TaskActivity> getActivities() {
    return activities;
  }

  public String getTaskDescription() {
    return taskDescription;
  }
}
