package com.share.loren.spring.aop.demo03;

import com.share.loren.spring.aop.demo03.config.Demo03Config;
import com.share.loren.spring.aop.demo03.service.Demo03Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lorenl
 * @date 11/19/2020
 */
public class AspectProxyTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo03Config.class);
        String save = applicationContext.getBean(Demo03Service.class).update("3");
        System.out.println(save);
    }

}
