package com.share.loren.aspectj.demo01;

import com.share.loren.aspectj.demo01.controller.DemoController;
import com.share.loren.aspectj.demo01.pojo.User;

/**
 * @author lorenl
 * @date 11/10/2020
 */
public class AspectJTest {

    public static void main(String[] args) {
        new DemoController().save("1");
        User user = new User();
        user.setName("Test");
    }

}
