package com.share.loren.spring.aop.demo03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lorenl
 * @date 11/10/2020
 */
@Configuration
@EnableAspectJAutoProxy
// @EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan(basePackages = "com.share.loren.spring.aop.demo03")
public class Demo03Config {

}
