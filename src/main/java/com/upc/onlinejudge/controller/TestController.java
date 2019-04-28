package com.upc.onlinejudge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sugar
 * just test tomcat
 */
@RestController
@RequestMapping("/test/")
public class TestController {

    @GetMapping("hello")
    public Object getHelloWorld() {
        return "helloWorld";
    }

}
