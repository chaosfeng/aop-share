package com.share.loren.aspectj.demo01.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author lorenl
 * @date 11/23/2020
 */
// @Aspect
public class AdviceExcutionAspect {

    // @Before("!within(AdviceExcutionAspect) && adviceexecution()")
    public void adviceExecutionAspect() {
        System.out.println("before advice execution");
    }
}
