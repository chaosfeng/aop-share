package com.share.loren.aop.usage.aop;

import com.share.loren.aop.usage.common.exception.InvalidRequestParamException;
import com.share.loren.aop.usage.common.util.PrintUtils;
import com.share.loren.aop.usage.common.validation.NotEmpty;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lorenl
 * @date 11/27/2020
 */
@Aspect
@Order(30)
@Configuration
public class RequestParamValidator {

    @Before(value = "com.share.loren.aop.usage.aop.pointcut.MyPointCut.restController()")
    public void validateRequestParam(JoinPoint joinPoint) throws IllegalAccessException {
        List<String> invalidParamsInfo = new ArrayList<>();
        for (Object arg : joinPoint.getArgs()) {
            for (Field field : arg.getClass().getDeclaredFields()) {
                boolean notEmpty = field.isAnnotationPresent(NotEmpty.class);
                if (notEmpty) {
                    field.setAccessible(true);
                    if (field.get(arg) == null) {
                        invalidParamsInfo.add(arg.getClass().getName() + "." + field.getName() + " must not be empty");
                    }
                }
            }
        }
        if (invalidParamsInfo.size() > 0) {
            throw new InvalidRequestParamException(400, "invalid request", invalidParamsInfo);
        } else {
            PrintUtils.print(Arrays.toString(joinPoint.getArgs()));
        }
    }
}
