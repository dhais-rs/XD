package com.js.xd.config;

import com.js.xd.model.HttpCode;
import com.js.xd.util.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 所有异常报错
     * @param
     * @return
     * @throws Exception
     */
//    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value=ServiceException.class)
    public Object ServiceExceptionHandler( ServiceException e)
    {
        e.printStackTrace();
        return ResultUtil.notLogin(e.getMessage());
    }
//    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(value=Exception.class)
//    public Object ExceptionHandler( Exception e)
//    {
//        e.printStackTrace();
//        return ResultUtil.fail("系统正在开小差！");
//    }
}