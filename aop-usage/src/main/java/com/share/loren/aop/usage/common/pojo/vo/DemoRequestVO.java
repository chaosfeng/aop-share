package com.share.loren.aop.usage.common.pojo.vo;

import com.share.loren.aop.usage.common.validation.NotEmpty;

/**
 * @author lorenl
 * @date 11/27/2020
 */
public class DemoRequestVO {

    public DemoRequestVO() {
    }

    public DemoRequestVO(String action) {
        this.action = action;
    }

    @NotEmpty
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "DemoRequestVO{" +
                "action='" + action + '\'' +
                '}';
    }
}
