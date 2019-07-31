package com.wxx.demo.dynamic;

import com.bj58.bic.oa.processplatform.activiti.bpmn.converter.BpmnJsonConverter;
import com.wxx.demo.ProcessEngineFactory;
import com.wxx.demo.convert.BpmnModelJsonFactory;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * ProcessDeploy.java
 *
 * @author wangxinxin07
 * @date 2019/7/30
 */
public class ProcessDeploy {


    /**
     * 部署bpmnMode对象
     *
     * @param bpmnModel
     * @throws Exception
     */
    public static void deployByBpmnModel(BpmnModel bpmnModel) throws Exception {
        DeploymentBuilder deployment = ProcessEngineFactory.getDefaultEngine().getRepositoryService().createDeployment();
        deployment.addBpmnModel("dynamic1.bpmn", bpmnModel).name("dynamic1").deploy();
        System.out.println("deploy success!!!");
    }

}
