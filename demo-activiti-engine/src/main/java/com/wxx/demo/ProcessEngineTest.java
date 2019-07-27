package com.wxx.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 * @文件名: ProcessEngineTest.java
 * @创建人: wangxinxin
 * @创建时间: 2019/7/17
 * @修改人: wangxinxin
 * @修改备注: <br/>
 * <p>
 * Copyright 西安创意 2019/07/17
 */
public class ProcessEngineTest {

    public static void main(String[] args) {

//        String processKey = "hrParam";
        //1.启动流程
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("u1", "zhangsan");
//        params.put("day", 1);
//        startProcess(processKey, params);

        String sn = "42501";
        //2.获取流程当前审批人 流程ID：42501
//        getTaskListBySn(sn);

        //3.直属上级审批
//        approve(sn);

        //4.获取流程当前审批人
//        getTaskListBySn(sn);


        ProcessEngine processEngine = createDefault();


    }

    /**
     * 默认方式创建ProcessEngine
     * 存在固化问题：
     * 1、activiti.cfg.xml或者activiti-context.xml文件必须位于classpath下
     * 2、流程引擎类名固定为 processEngine-Configuration
     *
     * @return
     */
    private static ProcessEngine createDefault() {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        System.out.println("pe = " + pe);
        return pe;
    }

    /**
     * classpath方式部署bpmn文件到引擎
     *
     * @param fileName
     */
    private static void deployProcessByBpmnFile(String fileName) {
        DeploymentBuilder deployment = createDefault().getRepositoryService().createDeployment();
        deployment.addClasspathResource("activiti/" + fileName).deploy();
    }

    /**
     * 启动流程
     *
     * @param processKey
     */
    private static void startProcess(String processKey) {
        ProcessInstance processInstance = createDefault().getRuntimeService().startProcessInstanceByKey(processKey);
        String processInstanceId = processInstance.getProcessInstanceId();
        System.out.println("processInstanceId = " + processInstanceId);
    }

    /**
     * 启动流程(带参数)
     * @param processKey
     * @param params
     */
    private static void startProcess(String processKey, Map<String, Object> params) {
        ProcessInstance processInstance = createDefault().getRuntimeService().startProcessInstanceByKey(processKey, params);
        String processInstanceId = processInstance.getProcessInstanceId();
        System.out.println("processInstanceId = " + processInstanceId);
    }


    /**
     * 获取待办
     *
     * @param sn
     */
    private static Task getTaskListBySn(String sn) {
        List<Task> list = createDefault().getTaskService().createTaskQuery().processInstanceId(sn).list();
        System.out.println("task list size = " + list.size());
        if (list != null && list.size() > 0) {
            System.out.println(list.get(0).getAssignee());
            System.out.println(list.get(0).getName());
            return list.get(0);
        }
        return null;
    }

    /**
     * 执行审批
     *
     * @param sn
     */
    private static void approve(String sn) {
        Task executeTask = getTaskListBySn(sn);
        if (executeTask == null) {
            System.out.println("流程已结束");
            return;
        }
        TaskService taskService = createDefault().getTaskService();
        taskService.complete(executeTask.getId());
        System.out.println("审批成功");
    }

    /**
     * 执行审批(带参数)
     * @param sn
     * @param paramsMap
     */
    private static void approve(String sn, Map<String, Object> paramsMap) {
        Task executeTask = getTaskListBySn(sn);
        if (executeTask == null) {
            System.out.println("流程已结束");
            return;
        }
        TaskService taskService = createDefault().getTaskService();
        taskService.complete(executeTask.getId(), paramsMap);
        System.out.println("审批成功");
    }
}
