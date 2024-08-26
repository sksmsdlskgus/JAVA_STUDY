package com.ohgiraffers.restapi.section02.responsentity;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entity")
public class ResponseEntityTestController {

    /* 필기.
    *   ResponseEntity란?
    *   HttpRequest를 응답하기 위해  httpEntity를 상속받아 HttpStatus,HttpHeaders,HttpBody,  */

    private List<UserDTO> users;

    public ResponseEntityTestController() {
        this.users = new ArrayList<>();

        users.add(new UserDTO(1,"user01","pass01","이나짱",new java.util.Date()));
        users.add(new UserDTO(2,"user02","pass02","이나련",new java.util.Date()));
        users.add(new UserDTO(3,"user03","pass03","현나이",new java.util.Date()));
    }

    /* 설명. 1. 직접 ResponseEntity 객체 만들기 */
    @GetMapping("users")
    public ResponseEntity<ResponseMessage>findAllUsers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("users",users);
        ResponseMessage responseMessage = new ResponseMessage(200,"조회성공!!",responseMap);

        return new ResponseEntity<>(responseMessage,headers, HttpStatus.OK);
    }


}


