package com.bolingcavalry.mavendockerplugindemo.Controller.Task;

import com.bolingcavalry.mavendockerplugindemo.PO.Task;
import com.bolingcavalry.mavendockerplugindemo.Service.Task.TaskService;
import com.bolingcavalry.mavendockerplugindemo.VO.ResponseVO;
import com.bolingcavalry.mavendockerplugindemo.VO.SearchTaskForm;
import com.bolingcavalry.mavendockerplugindemo.VO.TaskForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @RequestMapping(value = "/addTask",method = RequestMethod.POST)
    public ResponseVO addTask(@RequestBody TaskForm taskForm){
        return taskService.addTask(taskForm);
    }

    @RequestMapping(value = "/deleteTask", method = RequestMethod.DELETE)
    public ResponseVO deleteTask(@RequestParam("id")long id){
        return taskService.deleteTask(id);
    }

    @RequestMapping(value = "/getTaskInfo", method = RequestMethod.GET)
    public ResponseVO getTaskInfo(@RequestParam("id") long id){
        return taskService.getTaskInfo(id);
    }

    @RequestMapping(value = "/changeState", method = RequestMethod.GET)
    public ResponseVO changeState(@RequestParam("id") long id, @RequestParam("state") int state){
        return taskService.changeTaskState(id, state);
    }

    @RequestMapping(value = "/getAllTasks", method = RequestMethod.POST)
    public ResponseVO getAllTasks(@RequestBody SearchTaskForm searchTaskForm){
        return taskService.getAllTasks(searchTaskForm);
    }


}
