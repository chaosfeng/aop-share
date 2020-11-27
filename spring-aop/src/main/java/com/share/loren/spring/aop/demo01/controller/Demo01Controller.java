package com.share.loren.spring.aop.demo01.controller;

import com.share.loren.spring.aop.common.annotation.RecordExecuteTime;
import com.share.loren.spring.aop.common.util.PrintUtils;
import org.springframework.stereotype.Component;

/**
 * @author lorenl
 * @date 11/10/2020
 */
@Component
public class Demo01Controller {

    @RecordExecuteTime("demo01 save api")
    public String save(String o) {
        PrintUtils.print("Demo01Controller.save(String), param:" + o);
        // int i = 1/0;
        return "succeed";
    }

}
