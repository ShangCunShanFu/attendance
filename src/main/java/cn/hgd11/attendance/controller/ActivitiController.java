package cn.hgd11.attendance.controller;

import cn.hgd11.attendance.service.ActivityConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/activiti")
@ApiIgnore
public class ActivitiController {

    @Autowired
    private ActivityConsumerService activityConsumerService;

    /**
     * 注册流程
     * @return
     */
    @PostMapping("/createDeployment")
    public Boolean createDeployment(){
        return activityConsumerService.createDeployment();
    }

    /**
     * 启动流程
     * @return
     */
    @PostMapping("/startActivityDemo")
    public Boolean startActivityDemo(){
        return activityConsumerService.startActivityDemo("myProcess_1");
    }

    /**
     * 获取待办
     * @return
     */
    @GetMapping("/getTaskList")
    public boolean getTaskList(){
        return activityConsumerService.getTaskList();
    }

    /**
     * 提交
     * @param taskId
     * @return
     */
    @PostMapping("/complete")
    public boolean complete(String taskId){
        return activityConsumerService.complete(taskId);
    }
    /**
     * 根据流程id直接结束流程
     * @paramru
     * @return
     */
    @DeleteMapping("/deleteProcessInstance")
    public boolean deleteProcessInstance(String runId){
        return activityConsumerService.deleteProcessInstance(runId);
    }



}