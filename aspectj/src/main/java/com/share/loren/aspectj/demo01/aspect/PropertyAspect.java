package com.share.loren.aspectj.demo01.aspect;

import com.share.loren.aspectj.common.util.PrintUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lorenl
 * @date 11/23/2020
 */
@Aspect
public class PropertyAspect {

    @Pointcut("set(@com.share.loren.aspectj.common.annotation.ValueChangeListener * *)")
    public void listenedPropertyPointcut() {
    }

    @Around("listenedPropertyPointcut()")
    public Object listenToProperTySet(ProceedingJoinPoint joinPoint) throws Throwable {
        PrintUtils.print("@Around - PropertyAspect - start");
        PrintUtils.print(joinPoint.getThis());
        Object proceed = joinPoint.proceed(joinPoint.getArgs());
        PrintUtils.print(joinPoint.getThis());
        PrintUtils.print("@Around - PropertyAspect - end");
        return proceed;
    }

    @Before(value = "initialization(com.share.loren.aspectj.demo01.pojo..*.new())")
    public void beforeInitialization() {
        PrintUtils.print("@Before(value = \"initialization(com.share.loren.aspectj.demo01.pojo..*.new())\")");
    }
}
