package com.ohgiraffers.chap06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/* 설명.
*   인터셉터를 사용하는 경우(목적)
*   : 로그인 체크. 권한 체크. 프로그램 실행 시간 계산 작업 로그 처리, 업로드 파일 처리 , 로케일(지역) 설정 등 */
@Controller
public class InterceptorTestController {


    @GetMapping("stopwatch")
    public String handlerMethod() throws InterruptedException {
        System.out.println("핸들러 메소드 호출함....");

        Thread.sleep(1000);

        return "result";
    }
}
