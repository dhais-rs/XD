package com.js.xd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.js.xd.mapper")
public class XdApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdApplication.class, args);
    }

}
