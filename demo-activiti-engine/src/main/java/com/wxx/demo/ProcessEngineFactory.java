package com.wxx.demo;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

/**
 * ProcessEngineFactory.java
 *
 * @author wangxinxin07
 * @date 2019/7/30
 */
public class ProcessEngineFactory {

    /**
     * 创建默认的ProcessEngine
     *
     * @return
     */
    public static ProcessEngine getDefaultEngine() {
        return ProcessEngines.getDefaultProcessEngine();
    }
}
