package com.wxx.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

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
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        System.out.println("pe = " + pe);
    }
}
