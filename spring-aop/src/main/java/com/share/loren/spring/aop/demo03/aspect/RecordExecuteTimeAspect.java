package com.share.loren.spring.aop.demo03.aspect;

import com.share.loren.spring.aop.common.annotation.RecordExecuteTime;
import com.share.loren.spring.aop.common.util.PrintUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author lorenl
 * @date 11/17/2020
 */
@Aspect
@Configuration
public class RecordExecuteTimeAspect {

    @Around(value = "@annotation(recordExecuteTime)")
    public Object recordExecuteTimeAspect(ProceedingJoinPoint proceedingJoinPoint, RecordExecuteTime recordExecuteTime) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        printExecuteTime(proceedingJoinPoint, start, recordExecuteTime);
        return result;
    }

    private void printExecuteTime(ProceedingJoinPoint proceedingJoinPoint, long start, RecordExecuteTime recordExecuteTime) {
        StringBuffer stringBuffer = new StringBuffer()
                .append("--> Record execute time: ")
                .append(System.currentTimeMillis() - start)
                .append(", class name: ")
                .append(proceedingJoinPoint.getTarget().getClass().getName())
                .append(", method name: ")
                .append(proceedingJoinPoint.getSignature().getName())
                .append(", params:")
                .append(Arrays.toString(proceedingJoinPoint.getArgs()))
                .append(", desc: ").append(recordExecuteTime.value()).append(".");
        PrintUtils.print(stringBuffer.toString());
    }
}
