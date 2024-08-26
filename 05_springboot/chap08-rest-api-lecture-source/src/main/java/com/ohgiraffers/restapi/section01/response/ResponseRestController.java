package com.ohgiraffers.restapi.section01.response;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/response")
public class ResponseRestController {

    @GetMapping("hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("random")
    public int getRandomNumber() {
        return (int) (Math.random() * 10) + 1;
    }


    @GetMapping("message")
    public Message getMessage() {
        return new Message(200,"메시지를 응답합니다");
    }


    @GetMapping("jsonTest")
    public List<Map<String, Object>> getJsonTest() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("test1",new Message(200,"성공1"));
        map.put("test2",new Message(200,"성공2"));

        Map<String, Object> map2 = new HashMap<>();
        map2.put("nextUrl","http//localhost:8080//hello");

        list.add(map);
        list.add(map2);

        return list;
    }



}
