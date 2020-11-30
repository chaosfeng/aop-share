package com.share.loren.aop.usage.aop;

import com.share.loren.aop.usage.aop.annotation.InterceptRepeatCommit;
import com.share.loren.aop.usage.common.message.ResponseMessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author lorenl
 * @date 11/27/2020
 */
@Aspect
@Order(15)
@Configuration
public class RepeatCommitInterceptor {

    @Autowired
    private RedissonClient redissonClient;

    @Around("@annotation(interceptRepeatCommit)")
    public Object around(ProceedingJoinPoint point, InterceptRepeatCommit interceptRepeatCommit) throws Throwable {
        Object[] args = point.getArgs();

        String lockKey = point.getTarget().getClass().getName() + point.getSignature().getName() + Arrays.toString(args);
        RLock lock = redissonClient.getLock(lockKey);
        boolean res = lock.tryLock(interceptRepeatCommit.maxWaitTime(), interceptRepeatCommit.maxInterceptTime(), TimeUnit.SECONDS);
        if (res) {
            Object result;
            try {
                result = point.proceed();
            } finally {
                lock.unlock();
            }
            return result;
        }

        return ResponseMessage.failed("Repeat request.");
    }


}
