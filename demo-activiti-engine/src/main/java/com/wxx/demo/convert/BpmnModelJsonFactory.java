package com.wxx.demo.convert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.StartEvent;

/**
 * BpmnModelJsonFactory.java
 * 构造bpmnModel
 *
 * @author wangxinxin07
 * @date 2019/7/30
 */
public class BpmnModelJsonFactory {

    /**
     * 手工构造bpmnModejson
     * @return
     */
    public static String buildJson(){
        //process
        JSONObject process = new JSONObject();
        process.put("id", "processId");
        process.put("name", "processName");

        //startEvent
        JSONObject startEvent = new JSONObject();
        startEvent.put("id", "starEventId");
        startEvent.put("name", "StarEvent");

        //endEvent
        JSONObject endEvent = new JSONObject();
        endEvent.put("id", "endEventId");
        endEvent.put("name", "EndEvent");

        //直属上级
        JSONObject userTask1 = new JSONObject();
        userTask1.put("id", "userTask1");
        userTask1.put("name", "直属上级");
        userTask1.put("assignee", "${u1}");

        //部门经理
        JSONObject userTask2 = new JSONObject();
        userTask2.put("id", "userTask2");
        userTask2.put("name", "部门经理");
        userTask2.put("assignee", "${u2}");

        //flow1
        JSONObject flow1 = new JSONObject();
        flow1.put("id", "flow1");
        flow1.put("sourceRef", "starEventId");
        flow1.put("targetRef", "userTask1");

        //flow2
        JSONObject flow2 = new JSONObject();
        flow2.put("id", "flow2");
        flow2.put("sourceRef", "userTask1");
        flow2.put("targetRef", "userTask2");

        //flow3
        JSONObject flow3 = new JSONObject();
        flow3.put("id", "flow3");
        flow3.put("sourceRef", "userTask2");
        flow3.put("targetRef", "endEventId");


        JSONObject bpmnModel = new JSONObject();
        bpmnModel.put("startEvent", startEvent);
        bpmnModel.put("endEvent", endEvent);

        JSONArray userTask = new JSONArray();
        userTask.add(userTask1);
        userTask.add(userTask2);
        bpmnModel.put("userTask", userTask);

        JSONArray sequenceFlow = new JSONArray();
        sequenceFlow.add(flow1);
        sequenceFlow.add(flow2);
        sequenceFlow.add(flow3);
        bpmnModel.put("sequenceFlow", sequenceFlow);

        bpmnModel.put("process", process);

        return JSON.toJSONString(bpmnModel);
    }


}
