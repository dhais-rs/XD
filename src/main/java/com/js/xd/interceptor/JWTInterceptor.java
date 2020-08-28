package com.js.xd.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.js.xd.config.ServiceException;
import com.js.xd.util.JWTUtil;
import com.js.xd.util.ResultUtil;
import io.jsonwebtoken.Claims;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;
import java.io.PrintWriter;


public class JWTInterceptor extends HandlerInterceptorAdapter {

    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServiceException, IOException {
        String authHeader = request.getHeader("Authorization");
        //OPTIONS请求直接放过
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        if (authHeader.startsWith("wx")) {
            return true;
        }
        if (authHeader == null || !authHeader.startsWith("Bearer:")) {
            throw new ServiceException("用户未登录");
        }


        //取得token
        String token = authHeader.substring(7);

        //验证token
        Claims claims = JWTUtil.checkToken(token);

        request.setAttribute("username", claims.getSubject());

        return true;

    }
}