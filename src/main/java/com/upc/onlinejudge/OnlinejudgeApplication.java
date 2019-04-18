package com.upc.onlinejudge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangchunfei
 */
@SpringBootApplication
@MapperScan(basePackages = "tk.mybatis.pagehelper")
public class OnlinejudgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinejudgeApplication.class, args);
    }
}
