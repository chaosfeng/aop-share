package com.share.loren.aspectj.demo01.pojo;

import com.share.loren.aspectj.common.annotation.ValueChangeListener;
import com.share.loren.aspectj.common.util.PrintUtils;

/**
 * @author lorenl
 * @date 11/23/2020
 */
public class User {

    public User() {
        PrintUtils.print("constructor of User");
    }

    @ValueChangeListener
    String name;

    @ValueChangeListener
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
