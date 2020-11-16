package com.share.loren.aop.demo01.controller;

import org.springframework.stereotype.Component;
/**
 * @author lorenl
 * @date 11/10/2020
 */
@Component
public class DemoController implements BaseController{

    public String save(String o) {
        System.out.println("save method, param:" + o);
        // int i = 1/0;
        return "returnValFromSaveMethod";
    }

}
