package com.share.loren.aop.usage.controller;

import com.share.loren.aop.usage.aop.annotation.InterceptRepeatCommit;
import com.share.loren.aop.usage.aop.annotation.RecordExecuteTime;
import com.share.loren.aop.usage.common.exception.BizException;
import com.share.loren.aop.usage.common.message.ResponseMessage;
import com.share.loren.aop.usage.common.util.PrintUtils;
import com.share.loren.aop.usage.common.pojo.vo.DemoRequestVO;
import com.share.loren.aop.usage.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    DemoService demoService;

    @GetMapping("/demo")
    @InterceptRepeatCommit
    public ResponseMessage demoMethod(DemoRequestVO requestVO) {
        PrintUtils.print("DemoController.demoMethod(String),param:" + requestVO.toString());
        if (PERFORM_FAILURE_ACTION.equals(requestVO.getAction())) {
            throw new BizException(1000, "demo error");
        }
        demoService.demoInsert(requestVO.getAction());
        return ResponseMessage.succeed();
    }

}
