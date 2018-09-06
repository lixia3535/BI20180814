package com.xparsing.weixin.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 * Created by lx on 2018/8/30.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
       /* // 记录错误信息
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }*/
        log.error(e.getMessage(),e);
        Map<String,String> errorMap = new HashMap();
        errorMap.put("msg","系统异常，请联系管理员");
        errorMap.put("code","0");
        return errorMap;
    }


}
