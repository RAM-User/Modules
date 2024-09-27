//package com.activiti7;
//
//import org.activiti.bpmn.model.Task;
//import org.activiti.runtime.api.model.ProcessInstance;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.*;
//
//public class startProcessController {
//    /**
//     * 启动流程实例
//     * `act_hi_actinst`    流程实例执行历史信息
//     * `act_hi_identitylink` 流程参与用户的历史信息
//     * `act_hi_procinst`     流程实例的历史信息
//     * `act_hi_taskinst`     流程任务的历史信息
//     * `act_ru_execution`    流程执行信息
//     * `act_ru_identitylink`  流程的正在参与用户信息
//     * `act_ru_task`         流程当前任务信息
//     */
//    @RequestMapping("/startProcess")
//    public String startProcess(String key) {
//
//        // 1、根据流程定义的id启动流程
//        ProcessInstance instance = runtimeService.startProcessInstanceByKey(key);
//        // 2、输出内容
//        log.info("流程定义ID：" + instance.getProcessDefinitionId());
//        log.info("流程实例ID：" + instance.getId());
//        log.info("当前活动的ID：" + instance.getActivityId());
//
//        return "出差申请流程启动成功！";
//    }
//
//    /**
//     * 查询个人待执行的任务
//     */
//    @RequestMapping("/getUnfinishTaskList")
//    public List<Map<String,String>> getUnfinishTaskList(String key, String taskAssignee) {
//
//        // 1、根据流程key 和 任务的负责人 查询任务
//        List<Task> taskList = taskService.createTaskQuery()
//                .processDefinitionKey(key) //流程Key
//                .taskAssignee(taskAssignee)  //要查询的负责人
//                .list();
//
//        List<Map<String,String>> taskMapList = new ArrayList<>();
//        // 2、输出
//        for (Task task : taskList) {
//            Map<String,String> taskMap = new HashMap<>();
//            taskMap.put("processInstanceId",task.getProcessInstanceId());               //流程实例
//            taskMap.put("id",task.getId());                                             //任务Id
//            taskMap.put("assignee",task.getAssignee());                                 //任务负责人
//            taskMap.put("name",task.getName());                                         //任务名称
//
//            //取流程中设置的变量值（基本类型）
////            taskMap.put("taskAssignee", Objects.nonNull(taskService.getVariable(task.getId(),"出差申请人"))?taskService.getVariable(task.getId(),"出差申请人").toString():"");           //出差申请人
////            taskMap.put("days", Objects.nonNull(taskService.getVariable(task.getId(),"请假天数"))?taskService.getVariable(task.getId(),"请假天数").toString():"");                      //出差天数
////            taskMap.put("evaluateFee", Objects.nonNull(taskService.getVariable(task.getId(),"出差预计费用"))?taskService.getVariable(task.getId(),"出差预计费用").toString():"");        //出差预计费用
////            taskMap.put("startDate", Objects.nonNull(taskService.getVariable(task.getId(),"出差开始日期"))?taskService.getVariable(task.getId(),"出差开始日期").toString():"");          //出差开始日期
//
//            //取流程中设置的变量值（bean类型）
//            taskMap.put("approveInfo", Objects.nonNull(taskService.getVariable(task.getId(),"出差信息"))?JSONObject.toJSONString(taskService.getVariable(task.getId(),"出差信息")):"");
//
//            taskMapList.add(taskMap);
//        }
//
//        return taskMapList;
//    }
//
//    /**
//     * （以张三创建出差申请为例）
//     * 完成个人任务 : 创建出差申请
//     * `act_ru_task` 这里的 '创建出差申请' 会变为 '经理审批'
//     * 也就是也是下一个任务:  经理审批
//     * `act_hi_taskinst` 这里的'创建出差申请'这条记录会有开始时间和结束时间
//     * 然后还会增加一条记录 '经理审批'
//     */
//    @RequestMapping("/completeTask")
//    public String completeTask(String key,String taskAssignee,String days,String evaluateFee, String startDate) {
//
//        // 查找该负责人下所有的任务
//        Task task = taskService.createTaskQuery()
//                .processDefinitionKey(key)
//                .taskAssignee(taskAssignee)
//                .singleResult();
//
//        //设置流程变量（基本类型），前提是该流程实例必须未执行完成 —— 存在 act_ru_variable 表中，对应取值即可
////        taskService.setVariable(task.getId(), "请假人", taskAssignee);
////        taskService.setVariable(task.getId(), "出差天数",days);
////        taskService.setVariable(task.getId(), "出差预计费用", evaluateFee);
////        taskService.setVariable(task.getId(), "出差开始日期", startDate);
//
//        //设置流程变量（JavaBean类型），前提是该流程实例必须未执行完成 —— 存在 act_ru_variable 表中，但是实际值存在 act_ge_bytearray 表中
//        ApproveInfo approveInfo = ApproveInfo.builder()
//                .taskAssignee(taskAssignee)
//                .days(days)
//                .evaluateFee(evaluateFee)
//                .startDate(startDate)
//                .build();
//
//        taskService.setVariable(task.getId(),"出差信息",approveInfo);
//
//        //执行流程
//        taskService.complete(task.getId());
//
//        return "当前，" + task.getAssignee() + "已完成任务：" + task.getName() ;
//    }
//
//    /**
//     * 根据任务ID来完成任务
//     */
//    @RequestMapping("/completeTaskByTaskId")
//    public String completeTaskByTaskId(String taskId) {
//        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
//        taskService.complete(taskId);
//        return "当前已完成任务：" + task.getName() ;
//    }
//
//}
