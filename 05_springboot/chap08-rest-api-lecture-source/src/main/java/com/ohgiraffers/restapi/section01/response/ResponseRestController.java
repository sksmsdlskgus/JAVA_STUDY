package com.ohgiraffers.restapi.section01.response;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.IOException;
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


    /* 설명.
     *   RestController에서 반환한 값(자바의 타입들)은 모두 JSONArray형태([]), 또는 JSONObject형태({})로 바뀌어
     *   JSON 문자열로 반환된다.
     *   1. Map또는 일반 클래스 타입 -> {}형태
     *   2. ArrayList -> []형태
     *  */
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

    /* 설명. 이미지 응답하기
    *    produce는 response header의 content-type 설정이다.(jpeg에 대한 MIME 타입 설정) */
    @GetMapping(value = "image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage() throws IOException {
        return getClass().getResourceAsStream("/static/다운로드 (3).jpg").readAllBytes();
    }


    /* 설명. RespinseEntity를 활용한 응답(section02에서 자세히 다룰 예정) */
    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity() {
        return ResponseEntity.ok(new Message(200,"응답성공"));
    }



}
