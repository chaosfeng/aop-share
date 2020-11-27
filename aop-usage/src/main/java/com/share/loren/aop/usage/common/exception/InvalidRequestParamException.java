package com.share.loren.aop.usage.common.exception;

import java.util.Arrays;
import java.util.List;

/**
 * @author lorenl
 * @date 11/27/2020
 */
public class InvalidRequestParamException extends RuntimeException {

    public InvalidRequestParamException(Integer code, String message, List<String> invalidParamsInfo) {
        this.code = code;
        this.message = message;
        this.invalidParamsInfo = invalidParamsInfo;
    }

    private Integer code;

    private String message;

    private List<String> invalidParamsInfo;

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public List<String> getInvalidParamsInfo() {
        return invalidParamsInfo;
    }

    @Override
    public String toString() {
        return "InvalidRequestParamException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", invalidParamsInfo=" + Arrays.toString(invalidParamsInfo.toArray()) +
                '}';
    }
}
