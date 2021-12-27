package main;

import java.util.List;
import java.util.Map;

public class Driver {
  public static void main(String[] args) {
    Sprint sprint = new Sprint("Jira Board",null,15);
    Task task =new Task("System design","create class diagram ",TaskType.STORY,null);
    sprint.addTask(task);

    Map<TaskStatus, List<Task>> map =sprint.showBoard();

    for(Map.Entry entry :map.entrySet()){
      System.out.println("Status- "+entry.getKey());
      for (Task taskTemp:(List<Task>)entry.getValue()){
        System.out.println(taskTemp.taskId);
      }
    }

    sprint.getTask(1001).get().getActivities().forEach(s->System.out.println(s.description +" occured at " +s.activityDate));

  }
}
