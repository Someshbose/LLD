package main.model;

import main.model.IdGenerator;

import java.util.Date;

public class TaskActivity {
    private int id;
    private String description;
    private Date activityDate;

    TaskActivity(String description){
        this.id = IdGenerator.getId();
        this.description = description;
        this.activityDate = new Date(System.currentTimeMillis());
    }

    public String getDescription() {
        return description;
    }

    public Date getActivityDate() {
        return activityDate;
    }
}
