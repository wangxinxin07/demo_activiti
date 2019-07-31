package com.wxx.demo.convert;

import com.bj58.bic.oa.processplatform.activiti.bpmn.converter.BpmnJsonConverter;
import com.wxx.demo.ProcessEngineFactory;
import com.wxx.demo.dynamic.ProcessDeploy;
import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TestJsonConvertModel.java
 *
 * @author wangxinxin07
 * @date 2019/7/30
 */
public class TestJsonConvertModel {

    public static void main(String[] args) throws Exception{
//
        String bpmnModelJson = BpmnModelJsonFactory.buildJson();

        System.out.println(bpmnModelJson);

        BpmnJsonConverter converter = new BpmnJsonConverter();
        BpmnModel bpmnModel = converter.convertToBpmnModel(bpmnModelJson);
        new BpmnAutoLayout(bpmnModel).execute();
        ProcessDeploy.deployByBpmnModel(bpmnModel);

        ProcessEngine defaultEngine = ProcessEngineFactory.getDefaultEngine();

        String processId = bpmnModel.getMainProcess().getId();
        System.out.println("processId = " + processId);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("leader", Arrays.asList("zhangji"));
        ProcessInstance instance = defaultEngine.getRuntimeService().startProcessInstanceByKey(processId, params);
        System.out.println("sn = " + instance.getProcessInstanceId());

    }

}
