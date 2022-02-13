package com.bolingcavalry.mavendockerplugindemo.VO;

import com.bolingcavalry.mavendockerplugindemo.PO.Task;

import java.util.List;

public class TaskVOPage {
    private int num;
    private List<Task> taskList;

    public TaskVOPage(int num, List<Task> taskList) {
        this.num = num;
        this.taskList = taskList;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
