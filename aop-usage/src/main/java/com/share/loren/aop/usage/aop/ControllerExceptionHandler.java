package com.share.loren.aop.usage.aop;

import com.share.loren.aop.usage.common.exception.BizException;
import com.share.loren.aop.usage.common.exception.InvalidRequestParamException;
import com.share.loren.aop.usage.common.message.ResponseMessage;
import com.share.loren.aop.usage.common.util.PrintUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;

/**
 * @author lorenl
 * @date 11/27/2020
 */
@Aspect
@Order(10)
@Configuration
public class ControllerExceptionHandler {

    @Around(value = "com.share.loren.aop.usage.aop.pointcut.MyPointCut.restController()")
    public ResponseMessage handleControllerException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            return (ResponseMessage) proceedingJoinPoint.proceed();
        } catch (InvalidRequestParamException e) {
            PrintUtils.print(ExceptionUtils.getStackTrace(e));
            return ResponseMessage.failed("Invalid request param.", e.getInvalidParamsInfo().toArray(), e.getCode());
        } catch (BizException e) {
            PrintUtils.print(ExceptionUtils.getStackTrace(e));
            return ResponseMessage.failed(e.getMessage(), "", e.getCode());
        } catch (Exception e) {
            PrintUtils.print(ExceptionUtils.getStackTrace(e));
            return ResponseMessage.failed("Server is busy.", "", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

}
