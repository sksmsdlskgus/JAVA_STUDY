package com.ohgiraffers.eurekaclient;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {

    @GetMapping("/hello")
    public String hello() {
        return "안녕 ㅋㅋ";
    }

}
