package main;

import java.util.Date;

public class TaskActivity {
    int id;
    String description;
    Date activityDate;

    TaskActivity(String description){
        this.id = IdGenerator.getId();
        this.description = description;
        this.activityDate = new Date(System.currentTimeMillis());
    }
}
