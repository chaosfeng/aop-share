package com.share.loren.aop.usage.controller;

import com.share.loren.aop.usage.aop.annotation.RecordExecuteTime;
import com.share.loren.aop.usage.common.exception.BizException;
import com.share.loren.aop.usage.common.message.ResponseMessage;
import com.share.loren.aop.usage.common.util.PrintUtils;
import com.share.loren.aop.usage.common.pojo.vo.DemoRequestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lorenl
 * @date 11/20/2020
 */
@RestController
@RecordExecuteTime
public class DemoController {

    private final static String PERFORM_FAILURE_ACTION = "FAILURE";
    private final static String PERFORM_SUCCESS_ACTION = "SUCCESS";

    @GetMapping("/demo")
    public ResponseMessage demoMethod(DemoRequestVO requestVO) {
        PrintUtils.print("DemoController.demoMethod(String),param:" + requestVO.toString());
        if (PERFORM_FAILURE_ACTION.equals(requestVO.getAction())) {
            throw new BizException(1000, "demo error");
        }
        // todo demoservice transactional
        return ResponseMessage.succeed();
    }

}
