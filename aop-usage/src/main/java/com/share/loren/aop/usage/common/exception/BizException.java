package com.share.loren.aop.usage.common.exception;

/**
 * @author lorenl
 * @date 11/27/2020
 */
public class BizException extends RuntimeException {

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(String message, Integer code, Throwable cause) {
        super(message,cause);
        this.code = code;
    }

    private Integer code;

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return "BizException{" +
                "code=" + code + "," +
                "message=" + super.getMessage() +
                '}';
    }
}
