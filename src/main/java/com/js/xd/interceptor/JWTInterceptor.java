package com.js.xd.interceptor;

import com.js.xd.util.JWTUtil;
import io.jsonwebtoken.Claims;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


public class JWTInterceptor extends HandlerInterceptorAdapter {

    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer:")) {

            throw new Exception("用户未登录");

        }

//取得token

        String token = authHeader.substring(7);

//验证token

        Claims claims = JWTUtil.checkToken(token);

        request.setAttribute("username", claims.getSubject());

        return true;

    }
}