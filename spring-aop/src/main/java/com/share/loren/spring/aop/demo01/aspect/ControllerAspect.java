package com.share.loren.spring.aop.demo01.aspect;

import com.share.loren.spring.aop.common.annotation.RecordExecuteTime;
import com.share.loren.spring.aop.common.util.PrintUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author lorenl
 * @date 11/10/2020
 */
@Aspect
@Configuration
public class ControllerAspect {

    /**
     * execution(public * com.share.loren.spring.aop.demo01.controller..*.*(String))
     * <p>
     * execution（）表达式的主体
     * 1.public 访问修饰符   不写时除了private，其它修饰符均匹配
     * 2.第一个 * 符号	表示返回值的类型， * 代表所有返回类型
     * 3.com.share.loren.controller AOP 所切的服务的包名，即需要进行横切的业务类
     * 4.包名后面的 ..	表示当前包及子包
     * 5.第二个 *	表示类名， * 表示所有类 --> D*Controller,*Controller,Demo*
     * 6.最后的 .*(..)	第一个 . 表示任何方法名，括号内为参数类型， .. 代表任何类型参数，可以写具体的参数类型，以,分割
     **/
    @Pointcut(value = "execution(public String com.share.loren.spring.aop.demo01.controller.Demo01Controller.save(String))")
    public void demo01ControllerPointcut() {
    }

    @Before(value = "execution(public String com.share.loren.spring.aop.demo01.controller.Demo01Controller.save(String))")
    public void beforeControllerAspect(JoinPoint joinPoint) {
        PrintUtils.print("@Before(value = \"execution(public String com.share.loren.spring.aop.demo01.controller.Demo01Controller.save(String))\")");
    }

    @AfterReturning(value = "demo01ControllerPointcut() && args(param)")
    public void afterReturningControllerAspect(JoinPoint joinPoint, String param) {
        PrintUtils.print("@AfterReturning(value = \"demo01ControllerPointcut() && args(param)\"),param:" + param);
    }

    @AfterThrowing(value = "demo01ControllerPointcut()")
    public void afterThrowingControllerAspect(JoinPoint joinPoint) {
        PrintUtils.print("@AfterThrowing(value = \"demo01ControllerPointcut()\")");
    }

    @After(value = "within(com.share.loren.spring.aop.demo01.controller.Demo01Controller)")
    public void afterControllerAspect(JoinPoint joinPoint) {
        PrintUtils.print("@After(value = \"within(com.share.loren.spring.aop.demo01.controller.Demo01Controller)\")");
    }

    // @Pointcut(value = "@annotation(com.share.loren.spring.aop.common.annotation.RecordExecuteTime)")
    // private void recordExecuteTimePointCut() {
    // }

    @Pointcut(value = "@annotation(recordExecuteTime)")
    private void recordExecuteTimePointCut(RecordExecuteTime recordExecuteTime) {
    }

    @Around(value = "recordExecuteTimePointCut(recordExecuteTime)", argNames = "proceedingJoinPoint,recordExecuteTime")
    public Object recordExecuteTimeAspect(ProceedingJoinPoint proceedingJoinPoint, RecordExecuteTime recordExecuteTime) throws Throwable {
        PrintUtils.print("@Around - start");

        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        printExecuteTime(proceedingJoinPoint, start, recordExecuteTime);

        PrintUtils.print("@Around - end");
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
