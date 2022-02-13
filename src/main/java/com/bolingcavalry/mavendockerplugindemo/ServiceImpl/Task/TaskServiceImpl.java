package com.bolingcavalry.mavendockerplugindemo.ServiceImpl.Task;

import com.bolingcavalry.mavendockerplugindemo.Dao.TaskMapper;
import com.bolingcavalry.mavendockerplugindemo.PO.Task;
import com.bolingcavalry.mavendockerplugindemo.Service.Task.TaskService;
import com.bolingcavalry.mavendockerplugindemo.VO.ResponseVO;
import com.bolingcavalry.mavendockerplugindemo.VO.SearchTaskForm;
import com.bolingcavalry.mavendockerplugindemo.VO.TaskForm;
import com.bolingcavalry.mavendockerplugindemo.VO.TaskVOPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final static String ADD_TASK_FAILURE = "添加需求失败";
    private final static String GET_TASK_FAILURE = "获取需求失败";
    private final static String DELETE_TASK_FAILURE = "获取需求失败";
    private final static String GET_FAULT="任务获取出错";

    private final int FINISH_STATE = 2;
    private final int UNPUBLISHED_STATE = 0;
    private final int PUBLISHED_STATE = 1;

    private final static int ADMIN_MODE = 0;
    private final static int USER_MODE = 1;

    @Autowired
    TaskMapper taskMapper;

    @Override
    public ResponseVO getAllTasks(SearchTaskForm searchTaskForm){
        try{

            List<Task> taskList = new ArrayList<>();
            if(searchTaskForm.getState()==-1){
                taskList = taskMapper.getAllTasks();
            }else{
                taskList = taskMapper.getTaskByState(searchTaskForm.getState());
            }
            List<Task> res = new ArrayList<>();
            /*
                产品经历角色可以看到所有任务

                开发团队角色只能看到 已发布 和 已完成的任务
             */
            if(searchTaskForm.getUserRole()==ADMIN_MODE){
                res = taskList;
            }else if(searchTaskForm.getUserRole()==USER_MODE){
                for(Task task : taskList){
                    if(task.getState()!=0){
                        res.add(task);
                    }
                }
            }

            int max = res.size();
            int current = searchTaskForm.getCurrent();
            /*
                表示不做分页处理
             */
            if(current==-1){
                return ResponseVO.buildSuccess(new TaskVOPage(max, res));
            }
            List<Task> new_res = new ArrayList<>();
            if(max!=0){
                int fromindex = current * 10;
                int toindex = current * 10 + 10;
                if (fromindex >= max) {
                    new_res = null;
                } else if (toindex > max) {
                    new_res = res.subList(fromindex, max);
                } else {
                    new_res = res.subList(fromindex, toindex);
                }
            }
            TaskVOPage taskVOPage = new TaskVOPage(max, new_res);
            return ResponseVO.buildSuccess(taskVOPage);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure(GET_FAULT);
        }
    }

    @Override
    public ResponseVO addTask(TaskForm taskForm){
        try{
            Task task = new Task(taskForm);
            int res = taskMapper.addTask(task);
            if(res == 1){
                ResponseVO.buildSuccess();
            }
        }catch (Exception e){
            return ResponseVO.buildFailure(ADD_TASK_FAILURE);
        }
        return ResponseVO.buildFailure(ADD_TASK_FAILURE);
    }

    @Override
    public ResponseVO getTaskInfo(long id){
        try{
            Task task = taskMapper.getTaskById(id);
            return ResponseVO.buildSuccess(task);
        }catch (Exception e){
            return ResponseVO.buildFailure(GET_TASK_FAILURE);
        }
    }

    @Override
    public ResponseVO deleteTask(long id){
        try{
            taskMapper.deleteTaskById(id);
        }catch (Exception e){
            return ResponseVO.buildFailure(DELETE_TASK_FAILURE);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO changeTaskState(long id, int state){
        try{
            Task task = taskMapper.getTaskById(id);
            if(task==null){
                return ResponseVO.buildFailure("该需求不存在");
            }
            int old_state = task.getState();
            if(old_state == state){
                return ResponseVO.buildFailure("该任务状态没有变更");
            }
            if(old_state == UNPUBLISHED_STATE && state==FINISH_STATE){
                return ResponseVO.buildFailure("无法完成从未发布状态更改为已完成状态");
            }
            taskMapper.updateTaskState(id, state);
        }catch (Exception e){
            return ResponseVO.buildFailure("更改状态失败");
        }
        return ResponseVO.buildSuccess();
    }
}
