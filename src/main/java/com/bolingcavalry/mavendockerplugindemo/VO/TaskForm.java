package com.bolingcavalry.mavendockerplugindemo.VO;

import java.sql.Timestamp;

public class TaskForm {

    private String name;

    private int level;

    private int state;

    private int workload;

    private String description;

    private Timestamp startTime;

    public TaskForm(String name, int level, int state, int workload, String description, Timestamp startTime) {
        this.name = name;
        this.level = level;
        this.state = state;
        this.workload = workload;
        this.description = description;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}
