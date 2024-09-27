package com.activiti7;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;


public class ActivitiDemo {

    /**
     * 流程部署
     * `act_re_deployment`   流程部署表,每部署一次会增加一条记录
     * `act_re_procdef`      流程定义表,张三会申请出差流程,李四也会申请出差流程,每个人申请都会增加一条记录
     * act_re_deployment与act_re_procdef是一对多关系
     * `act_ge_bytearray`    流程资源表,每个资源都会增加一条记录
     */
    @Test
    public void testDeployment() throws FileNotFoundException {

        String evectionBpmnPath = ActivitiDemo.class.getClassLoader().getResource("bpmn/evection.bpmn").getFile();
        File evectionBpmnFile = new File(evectionBpmnPath);
        InputStream evectionBpmnIs = new FileInputStream(evectionBpmnFile);

        String evectionPngPath = ActivitiDemo.class.getClassLoader().getResource("bpmn/evection.png").getFile();
        File evectionPngFile = new File(evectionPngPath);
        InputStream evectionPngIs = new FileInputStream(evectionPngFile);

        // 1、创建ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2、获取RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3、使用service进行流程的部署，定义一个流程的名字，把bpmn和png部署到数据中
        Deployment deploy = repositoryService.createDeployment()
                .name("出差申请流程")
                .addInputStream("evection.bpmn", evectionBpmnIs)
                .addInputStream("evection.png", evectionPngIs)
                .deploy();

        // 4、输出部署信息
        System.out.println("流程部署id=" + deploy.getId());
        System.out.println("流程部署名字=" + deploy.getName());
    }

    /**
     * 启动流程实例
     * `act_hi_actinst`    流程实例执行历史信息
     * `act_hi_identitylink` 流程参与用户的历史信息
     * `act_hi_procinst`     流程实例的历史信息
     * `act_hi_taskinst`     流程任务的历史信息
     * `act_ru_execution`    流程执行信息
     * `act_ru_identitylink`  流程的正在参与用户信息
     * `act_ru_task`         流程当前任务信息
     */
    @Test
    public void testStartProcess() {
        // 1、创建ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、获取RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 3、根据流程定义的id启动流程
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("myEvection");
        // 4、输出内容
        System.out.println("流程定义ID：" + instance.getProcessDefinitionId());
        System.out.println("流程实例ID：" + instance.getId());
        System.out.println("当前活动的ID：" + instance.getActivityId());
    }

    /**
     * 查询个人待执行的任务
     */
    @Test
    public void testFindPersonalTaskList() {
        // 1、获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、获取taskService
        TaskService taskService = processEngine.getTaskService();
        // 3、根据流程key 和 任务的负责人 查询任务
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("myEvection") //流程Key
                .taskAssignee("李四")  //要查询的负责人
                .list();
        // 4、输出
        for (Task task : taskList) {
            System.out.println("流程实例id=" + task.getProcessInstanceId());
            System.out.println("任务Id=" + task.getId());
            System.out.println("任务负责人=" + task.getAssignee());
            System.out.println("任务名称=" + task.getName());
        }
    }

    /**
     * 完成个人任务 : 创建出差申请
     * `act_ru_task` 这里的 '创建出差申请' 会变为 '经理审批'
     * 也就是也是下一个任务:  经理审批
     * `act_hi_taskinst` 这里的'创建出差申请'这条记录会有开始时间和结束时间
     * 然后还会增加一条记录 '经理审批'
     */
    @Test
    public void completeTask() {
        // 获取引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取操作任务的服务 TaskService
        TaskService taskService = processEngine.getTaskService();
        // 完成任务,参数：任务id,完成 '张三' 的任务
        taskService.complete("2505");
    }

    // 改造: 不把id写死,通过查询,然后执行任务
    // 完成经理'李四'的任务
    @Test
    public void completeTask2() {
        // 获取引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取操作任务的服务 TaskService
        TaskService taskService = processEngine.getTaskService();
        // 完成 经理 '李四' 的任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("myEvection")
                .taskAssignee("李四")
                .singleResult();

        System.out.println("流程实例id=" + task.getProcessInstanceId());
        System.out.println("任务Id=" + task.getId());
        System.out.println("任务负责人=" + task.getAssignee());
        System.out.println("任务名称=" + task.getName());

        taskService.complete(task.getId());
    }

    // 完成总经理'老马'的任务
    @Test
    public void completeTask3() {
        // 获取引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取操作任务的服务 TaskService
        TaskService taskService = processEngine.getTaskService();
        // 完成 经理 '李四' 的任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("myEvection")
                .taskAssignee("老马")
                .singleResult();

        System.out.println("流程实例id=" + task.getProcessInstanceId());
        System.out.println("任务Id=" + task.getId());
        System.out.println("任务负责人=" + task.getAssignee());
        System.out.println("任务名称=" + task.getName());

        taskService.complete(task.getId());
    }

    // 完成财务'小王'的任务
    @Test
    public void completeTask4() {
        // 获取引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取操作任务的服务 TaskService
        TaskService taskService = processEngine.getTaskService();
        // 完成 经理 '李四' 的任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("myEvection")
                .taskAssignee("小王")
                .singleResult();

        System.out.println("流程实例id=" + task.getProcessInstanceId());
        System.out.println("任务Id=" + task.getId());
        System.out.println("任务负责人=" + task.getAssignee());
        System.out.println("任务名称=" + task.getName());

        taskService.complete(task.getId());
    }

    // 如果一个流程中有多个任务,可以用list
    @Test
    public void completeTask5() {
        // 获取引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取操作任务的服务 TaskService
        TaskService taskService = processEngine.getTaskService();
        // 完成 经理 '李四' 的任务
        List<Task> tasks = taskService.createTaskQuery()
                .processDefinitionKey("myEvection")
                .taskAssignee("李四")
                .list();  // 多个任务,用list

        for (Task task : tasks) {
            if (true) {
                // 判断是哪任务
                System.out.println("流程实例id=" + task.getProcessInstanceId());
                System.out.println("任务Id=" + task.getId());
                System.out.println("任务负责人=" + task.getAssignee());
                System.out.println("任务名称=" + task.getName());
                taskService.complete(task.getId());
            }
        }
    }
}
