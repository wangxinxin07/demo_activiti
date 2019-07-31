package com.wxx.demo.dynamic;

import com.alibaba.fastjson.JSON;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.util.io.InputStreamSource;
import org.activiti.engine.repository.DeploymentBuilder;

import java.io.InputStream;

/**
 * DeployProcessTest.java
 * 流程部署
 *
 * @author wangxinxin07
 * @date 2019/7/29
 */
public class DeployProcessTest {


    public static void main(String[] args) {

        String bpmnFileName = "activiti/PurchaseMerge.bpmn";
        BpmnModel bpmnModel = convertToBpmnModel(bpmnFileName);

        System.out.println(JSON.toJSONString(bpmnModel));

    }

    /**
     * 将bpmnfile转为bpmnmodel
     *
     * @param bpmnFileName
     * @return
     */
    protected static BpmnModel convertToBpmnModel(String bpmnFileName) {
        InputStream xmlStream = DeployProcessTest.class.getClassLoader().getResourceAsStream(bpmnFileName);
        InputStreamSource xmlSource = new InputStreamSource(xmlStream);
        BpmnXMLConverter bpmnXMLConverter = new BpmnXMLConverter();
        BpmnModel bpmnModel = bpmnXMLConverter.convertToBpmnModel(xmlSource, true, false, "UTF-8");
        return bpmnModel;
    }


    private static ProcessEngine getdefaultEngine() {
        return ProcessEngines.getDefaultProcessEngine();
    }

}
