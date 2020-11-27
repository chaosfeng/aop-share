package com.share.loren.aspectj.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lorenl
 * @date 11/17/2020
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RecordExecuteTime {

    /**
     * desc
     * @return
     */
    String value() default "";

}
