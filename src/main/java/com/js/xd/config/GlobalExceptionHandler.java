package com.js.xd.config;

import com.js.xd.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 所有异常报错
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)
    public Object allExceptionHandler( Exception exception) throws Exception
    {
        exception.printStackTrace();

        return ResultUtil.fail(0,exception.getMessage());
    }
}