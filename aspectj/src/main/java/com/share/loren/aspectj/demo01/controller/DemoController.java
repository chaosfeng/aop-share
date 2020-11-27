package com.share.loren.aspectj.demo01.controller;

import com.share.loren.aspectj.common.annotation.RecordExecuteTime;
import com.share.loren.aspectj.common.util.PrintUtils;

/**
 * @author lorenl
 * @date 11/10/2020
 */
public class DemoController {

    @RecordExecuteTime("demo save api")
    public String save(String o) {
        PrintUtils.print("DemoController.save(String), param:" + o);
        return "succeed";
    }

}
