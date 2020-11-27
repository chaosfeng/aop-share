package com.share.loren.spring.aop.demo03.service;

import com.share.loren.spring.aop.common.annotation.RecordExecuteTime;
import com.share.loren.spring.aop.common.util.PrintUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * @author lorenl
 * @date 11/19/2020
 */
@Component
public class Demo03Service {

    @RecordExecuteTime("update")
    public String update(String o) {
        PrintUtils.print("Demo03Service.update(String), param:" + o);
        recordHistory(o);
        // ((Demo03Service) AopContext.currentProxy()).recordHistory(o);
        return "succeed";
    }

    @RecordExecuteTime("record history")
    public String recordHistory(String o) {
        PrintUtils.print("Demo03Service.recordHistory(String), param:" + o);
        return "succeed";
    }

}
