package com.ohgiraffers.firstservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j // 로그 찍기
public class FirstServiceController {

    /* 설명. port 번호 확인을 위한 Environment 객헤 생성자 주입 */
    private Environment env; // yml에 쓴 변수를 불러올 수 있다.

    @Autowired
    public FirstServiceController(Environment env) {
        this.env = env;
    }

    @GetMapping("/health")
    public String healthCheck() {

        /* 설명. Gateway의 lb(로드 밸런싱)을 통해 RoundRobin 방식으로 실행 될 마이크로 서비스의 포트 번호 확인*/
        return "I'm OK 포트는 " + env.getProperty("local.server.port") ;
    }

    @GetMapping("message")
    public String message(@RequestHeader("first-request") String header) {
        log.info("넘어온 헤더값 : {}", header);
        return "First Service Message ";

    }
}
