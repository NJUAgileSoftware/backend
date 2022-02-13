package com.bolingcavalry.mavendockerplugindemo.PO;


import com.bolingcavalry.mavendockerplugindemo.VO.TaskForm;

import java.sql.Timestamp;

public class Task {
    private long id;
    private String name;
    //优先级
    private int level;
    //状态
    private int state;
    //工作量
    private int workload;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;

    public Task(){

    }

    public Task(TaskForm taskForm){
        this.id = 0;
        this.name = taskForm.getName();
        this.level = taskForm.getLevel();
        this.state = taskForm.getState();
        this.workload = taskForm.getWorkload();
        this.description = taskForm.getDescription();
        this.startTime = taskForm.getStartTime();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
