package com.share.loren.spring.aop.demo02;

import com.share.loren.spring.aop.demo02.config.Demo02Config;
import com.share.loren.spring.aop.demo02.controller.Demo02Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lorenl
 * @date 11/19/2020
 */
public class AspectOrderTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo02Config.class);
        String save = applicationContext.getBean(Demo02Controller.class).save("2");
        System.out.println(save);
    }

}
