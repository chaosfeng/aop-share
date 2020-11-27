package com.share.loren.spring.aop.demo01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lorenl
 * @date 11/10/2020
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.share.loren.spring.aop.demo01")
public class Demo01Config {

}
