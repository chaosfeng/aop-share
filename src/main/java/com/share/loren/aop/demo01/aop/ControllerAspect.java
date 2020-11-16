package com.share.loren.aop.demo01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lorenl
 * @date 11/10/2020
 */
@Aspect
@Component
public class ControllerAspect {

    /**
     * execution（）表达式的主体
     * 1.public访问修饰符，可以省略。省略时除了private，其它全部代理
     * 2.第一个 * 符号	表示返回值的类型， * 代表所有返回类型
     * 3.com.share.loren.controller AOP 所切的服务的包名，即需要进行横切的业务类
     * 4.包名后面的 ..	表示当前包及子包
     * 5.第二个 *	表示类名， * 表示所有类
     * 6.最后的 .*(..)	第一个 . 表示任何方法名，括号内为参数类型， .. 代表任何类型参数，可以写具体的参数类型，以,分割
     */
    @Pointcut(value = "execution(* com.share.loren.aop.demo01.controller..*.*(String))")
    public void pointCutUsingExecution() {

    }

    @Before(value = "pointCutUsingExecution()")
    public void beforeControllerAspect(JoinPoint joinPoint) {
        System.out.println("Controller before aspect");
        // int i = 1/0;
    }

    @AfterReturning(value = "pointCutUsingExecution()")
    public void afterReturningControllerAspect(JoinPoint joinPoint) {
        System.out.println("Controller after returning aspect");
        // int i = 1/0;
    }

    @AfterThrowing(value = "pointCutUsingExecution()")
    public void afterThrowingControllerAspect(JoinPoint joinPoint) {
        System.out.println("Controller after throwing aspect");
        // int i = 1/0;
    }

    @After(value = "pointCutUsingExecution()")
    public void afterControllerAspect(JoinPoint joinPoint) {
        System.out.println("Controller after aspect");
        // int i = 1 / 0;
    }

    @Around(value = "pointCutUsingExecution()")
    public Object doBasicProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            Object retVal = proceedingJoinPoint.proceed();
            return retVal;
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

}
