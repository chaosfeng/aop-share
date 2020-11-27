package com.share.loren.spring.aop.demo01;

import com.share.loren.spring.aop.demo01.controller.Demo01Controller;
import com.share.loren.spring.aop.demo01.config.Demo01Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lorenl
 * @date 11/10/2020
 */
public class AspectBasicTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo01Config.class);
        String save = applicationContext.getBean(Demo01Controller.class).save("1");
        System.out.println(save);
    }

}
