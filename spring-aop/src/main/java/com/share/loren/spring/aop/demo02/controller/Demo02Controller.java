package com.share.loren.spring.aop.demo02.controller;

import com.share.loren.spring.aop.common.util.PrintUtils;
import org.springframework.stereotype.Component;

/**
 * @author lorenl
 * @date 11/19/2020
 */
@Component
public class Demo02Controller {

    public String save(String o) {
        PrintUtils.print("Demo01Controller.save(String), param:" + o);
        return "succeed";
    }

}
