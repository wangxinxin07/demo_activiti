package com.wxx.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * @描述: 初始化数据库
 * @文件名: InitTableFirst.java
 * @创建人: wangxinxin
 * @创建时间: 2019/7/17
 * @修改人: wangxinxin
 * @修改备注: <br/>
 * <p>
 * Copyright 西安创意 2019/07/17
 */
public class InitTableFirst {

    public static void main(String[] args) {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        // 链接数据库的配置
        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://47.98.141.146:3306/activiti5_home2?useUnicode=true&characterEncoding=utf8");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("7uji9olp-");
        /*
         * DB_SCHEMA_UPDATE_FALSE 不能创建表，需要表存在
         * DB_SCHEMA_UPDATE_CREATE_DROP 先删除表再创建表
         * DB_SCHEMA_UPDATE_TRUE 如表不存在自动创建表
         */
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        //工作流的核心对象，ProcessEngine对象
        ProcessEngine processEngine= configuration.buildProcessEngine();
        System.out.println("processEngine="+processEngine);
    }
}
