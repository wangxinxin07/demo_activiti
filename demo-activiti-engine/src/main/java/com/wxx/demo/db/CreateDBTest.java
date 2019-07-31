package com.wxx.demo.db;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.activiti.engine.ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE;

/**
 * CreateDBTest.java
 * 创建数据库操作
 *
 * @author wangxinxin07
 * @date 2019/7/27
 */
public class CreateDBTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(CreateDBTest.class);

    public static final Log LOG = LogFactory.getLog(CreateDBTest.class);

    public static void main(String[] args) {
//        createByDefault();

//        String xmlPath = "activiti.cfg222.xml";
//        createByConfig(xmlPath);

        createByCode();
    }

    /**
     * 1\默认方式创建 配置文件必须为activiti.cfg.xml
     */
    private static void createByDefault() {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(defaultProcessEngine);
        LOGGER.info("defaultProcessEngine = {}", defaultProcessEngine);
    }

    /**
     * 2\指定xml文件路径
     *
     * @param xmlPath
     */
    private static void createByConfig(String xmlPath) {
        LOGGER.info("xmlPath = {}", xmlPath);
        ProcessEngineConfiguration peg = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource(xmlPath);
        ProcessEngine processEngine = peg.buildProcessEngine();
        LOGGER.info("processEngine = {}", processEngine);
    }

    /**
     *  3\代码指定mysql创建
     */
    private static void createByCode() {
        ProcessEngineConfiguration peg = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        peg.setJdbcDriver("com.mysql.jdbc.Driver");
        peg.setJdbcUrl("jdbc:mysql://47.98.141.146:3306/activiti5_home?useUnicode=true&amp;characterEncoding=utf8");
        peg.setJdbcUsername("root");
        peg.setJdbcPassword("7uji9olp-");
        peg.setDatabaseSchemaUpdate(DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = peg.buildProcessEngine();
        LOGGER.info("processEngine = {}", processEngine);
    }



}
