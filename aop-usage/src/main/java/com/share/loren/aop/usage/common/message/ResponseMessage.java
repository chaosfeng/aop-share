package com.share.loren.aop.usage.common.message;

import org.springframework.http.HttpStatus;

/**
 * @author lorenl
 * @date 11/27/2020
 */
public class ResponseMessage {

    public static final int DEFAULT_SUCCEED_CODE = HttpStatus.OK.value();

    public static final int DEFAULT_FAILED_CODE = HttpStatus.BAD_REQUEST.value();

    public static final String DEFAULT_SUCCEED_MESSAGE = "succeed";

    public static final String DEFAULT_FAILED_MESSAGE = "failed";

    private String message;

    private Object data;

    private Integer code;

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public Integer getCode() {
        return code;
    }

    protected ResponseMessage(String message, Object data, Integer code) {
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public static ResponseMessage succeed() {
        return new ResponseMessage(DEFAULT_SUCCEED_MESSAGE, null, DEFAULT_SUCCEED_CODE);
    }

    public static ResponseMessage succeed(Object object) {
        return new ResponseMessage(DEFAULT_SUCCEED_MESSAGE, object, DEFAULT_SUCCEED_CODE);
    }

    public static ResponseMessage succeed(String message, Object object, Integer code) {
        return new ResponseMessage(message, object, code);
    }

    public static ResponseMessage failed() {
        return new ResponseMessage(DEFAULT_FAILED_MESSAGE, null, DEFAULT_FAILED_CODE);
    }

    public static ResponseMessage failed(String message) {
        return new ResponseMessage(message, null, DEFAULT_FAILED_CODE);
    }

    public static ResponseMessage failed(String message, Object object, Integer code) {
        return new ResponseMessage(message, object, code);
    }

}
