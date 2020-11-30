package com.share.loren.aop.usage;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lorenl
 * @date 11/20/2020
 */
@EnableRedisRepositories
@EnableAspectJAutoProxy
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.share.loren.aop.usage")
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }

}
