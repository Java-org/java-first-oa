package com.xub.common.exception;

import com.xub.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常处理，统一返回数据格式
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    //@ResponseBody：设置当前控制器方法响应内容为当前返回值，无需解析即如果写在方法上，则将方法的返回内容作为响应体返回给前端
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail();
    }
}
