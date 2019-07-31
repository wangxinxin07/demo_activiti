package com.wxx.demo.generator;

import org.activiti.engine.impl.cfg.IdGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TimeGenerator.java
 * 自定义时间生成器
 *
 * @author wangxinxin07
 * @date 2019/7/27
 */
public class TimeGenerator implements IdGenerator {

    public String getNextId() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStr = simpleDateFormat.format(new Date());
        String resultId = timeStr + System.nanoTime();
        System.out.println("resultId = " + resultId);
        return resultId;
    }
}
