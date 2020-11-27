package com.share.loren.aop.usage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lorenl
 * @date 11/20/2020
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demoMethod(String a) {
        return "";
    }

}
