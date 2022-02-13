package com.bolingcavalry.mavendockerplugindemo.Service.Task;


import com.bolingcavalry.mavendockerplugindemo.PO.Task;
import com.bolingcavalry.mavendockerplugindemo.VO.ResponseVO;
import com.bolingcavalry.mavendockerplugindemo.VO.SearchTaskForm;
import com.bolingcavalry.mavendockerplugindemo.VO.TaskForm;

public interface TaskService {

    ResponseVO addTask(TaskForm taskForm);

    ResponseVO deleteTask(long id);

    ResponseVO getTaskInfo(long id);

    ResponseVO changeTaskState(long id, int state);

    ResponseVO getAllTasks(SearchTaskForm searchTaskForm);
}
