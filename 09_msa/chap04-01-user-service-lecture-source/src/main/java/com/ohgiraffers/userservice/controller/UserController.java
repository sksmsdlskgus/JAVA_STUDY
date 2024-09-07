package com.ohgiraffers.userservice.controller;

import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.service.UserService;
import com.ohgiraffers.userservice.vo.Hello;
import com.ohgiraffers.userservice.vo.RequestResistUserVO;
import com.ohgiraffers.userservice.vo.ResponseFindUserVO;
import com.ohgiraffers.userservice.vo.ResponseRegistUserVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    private Environment env;
    private Hello hello;
    private ModelMapper modelMapper;
    private UserService userService;

    @Autowired
    public UserController(Environment env,
                          Hello hello,
                          ModelMapper modelMapper,
                          UserService userService) {
        this.env = env;
        this.hello = hello;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/health")
    public String status() {
        return "I'm Working in User Service " + env.getProperty("local.server.port") +
                ", test.message: " + env.getProperty("test.message");
    }

    /* 설명. 해당 마이크로 서비스가 application.yml에 설정 값이 제대로 들어 있는지 확인(feat. @Value) */
    @GetMapping("/welcome")
    public String welcome() {
        return hello.getMessage();
    }
    
    /* 설명. 로그인 기능(feat. security 모듈 활용) 전에 회원가입 기능 만들기 */
    @PostMapping("users")
    public ResponseEntity<ResponseRegistUserVO> registUser(@RequestBody RequestResistUserVO newUser) {
        UserDTO userDTO = modelMapper.map(newUser, UserDTO.class);

        userService.registUser(userDTO);

//        return ResponseEntity.status(HttpStatus.OK).build();

        ResponseRegistUserVO responseUser = modelMapper.map(userDTO, ResponseRegistUserVO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users/{memNo}")
    public ResponseEntity<ResponseFindUserVO> getUser(@PathVariable("memNo") String memNo) {
        UserDTO userDTO = userService.getUserByUserId(memNo);

        log.info("modelmapper 매핑 전(controller): {}", userDTO);
        ResponseFindUserVO findUser = modelMapper.map(userDTO, ResponseFindUserVO.class);
        log.info("modelmapper 매핑 후(controller): {}", findUser);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(findUser);
    }

}







