package com.share.loren.aop.usage.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lorenl
 * @date 11/30/2020
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterceptRepeatCommit {

    String value() default "";

    /**
     * seconds
     */
    int maxWaitTime() default 3;

    /**
     * seconds
     */
    int maxInterceptTime() default 5;

}
