package com.share.loren.spring.aop.demo02.aspect;

import com.share.loren.spring.aop.common.annotation.RecordExecuteTime;
import com.share.loren.spring.aop.common.util.PrintUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @author lorenl
 * @date 11/19/2020
 */
@Aspect
@Order(1)
@Configuration
public class ControllerAspectOrder01 {

    @Pointcut(value = "execution(* com.share.loren.spring.aop.demo02.controller..*.*(String))")
    public void controllerInDemo02() {

    }

    @Before(value = "controllerInDemo02()")
    public void beforeControllerAspect() {
        PrintUtils.print("Controller before aspect Order 1");
    }

    @After(value = "controllerInDemo02()")
    public void afterControllerAspect(JoinPoint joinPoint) {
        PrintUtils.print("Controller after aspect Order 1");
    }

    @Around(value = "controllerInDemo02()")
    public Object aroundControllerAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        PrintUtils.print("Controller around aspect Order 1 - start");

        Object result = proceedingJoinPoint.proceed();

        PrintUtils.print("Controller around aspect Order 1 - end");
        return result;
    }
}
