package com.share.loren.aop.usage.aop.pointcut;

import com.share.loren.aop.usage.aop.annotation.RecordExecuteTime;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lorenl
 * @date 11/27/2020
 */
public class MyPointCut {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController))")
    public void restController() {

    }

    @Pointcut(value = "@annotation(recordExecuteTime) || @within(recordExecuteTime)")
    public void recordExecuteTimePointCut(RecordExecuteTime recordExecuteTime) {

    }

}
