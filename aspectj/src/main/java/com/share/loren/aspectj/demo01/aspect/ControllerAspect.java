package com.share.loren.aspectj.demo01.aspect;

import com.share.loren.aspectj.common.annotation.RecordExecuteTime;
import com.share.loren.aspectj.common.util.PrintUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * @author lorenl
 * @date 11/10/2020
 */
@Aspect
public class ControllerAspect {

    // @Pointcut(value = "@annotation(recordExecuteTime) && call(* *.*(..))")
    @Pointcut(value = "@annotation(recordExecuteTime) && execution(* *.*(..))")
    private void recordExecuteTimePointCut(RecordExecuteTime recordExecuteTime) {
    }

    @Around(value = "recordExecuteTimePointCut(recordExecuteTime)")
    public Object recordExecuteTimeAspect(ProceedingJoinPoint proceedingJoinPoint, RecordExecuteTime recordExecuteTime) throws Throwable {
        PrintUtils.print("@Around - ControllerAspect - start");

        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        printExecuteTime(proceedingJoinPoint, start, recordExecuteTime);

        PrintUtils.print("@Around - ControllerAspect - end");
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
