package com.upc.onlinejudge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author wangchunfei
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = "tk.mybatis.pagehelper")
public class OnlinejudgeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OnlinejudgeApplication.class, args);
    }

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(OnlinejudgeApplication.class);
    }
}
