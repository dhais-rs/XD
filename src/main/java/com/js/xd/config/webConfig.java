package com.js.xd.config;

import com.js.xd.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class webConfig implements WebMvcConfigurer {


    public void addInterceptors(InterceptorRegistry registry) {

    //添加拦截器

        registry.addInterceptor(new JWTInterceptor()).excludePathPatterns("/adminLogin", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");//放掉某些特定不需要校验token的路由

    }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
