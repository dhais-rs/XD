package com.js.xd.config;

import com.js.xd.model.HttpCode;

public class ServiceException extends Exception {

    public ServiceException() {
    }

    private HttpCode httpCode= HttpCode.OK;

    private Integer msgCode = null;

    private HttpCode getHttpCode() {
        return httpCode;
    }

    private void setHttpCode(HttpCode httpCode) {
        this.httpCode = httpCode;
    }

    public void setMsgCode(Integer msgCode) {
        this.msgCode = msgCode;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(HttpCode httpCode,String message) {
        super(message);
        setHttpCode(httpCode);
    }

    public ServiceException(HttpCode httpCode, Integer msgCode, String message) {
        super(message);
        setHttpCode(httpCode);
        setMsgCode(msgCode);
    }


    public ServiceException(String message, Exception e) {
        super(message, e);
        setHttpCode(httpCode);
    }



    public ServiceException(HttpCode httpCode,String message, Exception e) {
        super(message, e);
        setHttpCode(httpCode);
    }

    public ServiceException(HttpCode httpCode,Integer msgCode,String message, Exception e) {
        super(message, e);
        setHttpCode(httpCode);
        setMsgCode(msgCode);
    }

    public HttpCode getCode() {
        return getHttpCode();
    }

    public Integer getMsgCode() {
        return msgCode;
    }
}
