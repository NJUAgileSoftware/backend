package com.bolingcavalry.mavendockerplugindemo.Dao;


import com.bolingcavalry.mavendockerplugindemo.PO.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {

    int addTask(Task task);

    Task getTaskById(long id);

    int deleteTaskById(long id);

    int setTaskEndTime(long id);

    int updateTaskState(long id, int state);

    List<Task> getAllTasks();

    List<Task> getTaskByState(int state);
}
