package com.share.loren.aop.demo01;

import com.share.loren.aop.demo01.config.EnableAutoScanConfig;
import com.share.loren.aop.demo01.controller.BaseController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lorenl
 * @date 11/10/2020
 */
public class Demo01 {

    public static void main(String[] args) {
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./gen");  // 输出cglib动态代理产生的类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");   // 输出jdk动态代理产生的类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EnableAutoScanConfig.class);
        String save = applicationContext.getBean(BaseController.class).save("1");
        System.out.println(save);
    }

}
