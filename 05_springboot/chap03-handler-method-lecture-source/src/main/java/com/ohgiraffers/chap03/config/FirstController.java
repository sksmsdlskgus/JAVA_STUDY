package com.ohgiraffers.chap03.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/* 설명. 현재의 Controller 클래스에 작성할 핸들러 메소드들이 모두 /first/***의 요청을 받게 될 것이다.(보통은 도메인) */
@Controller
@RequestMapping("/first")
public class FirstController {

    /* 설명. 반환형이 void인 핸들러 메소드는 요청 경로 자체가 view의 경로 및 이름을 반환한 것으로 바로 해석된다. */
//    @GetMapping("regist")
//    public String regist() {
//        return "/first/regist";
//    }

    @GetMapping("regist")
    public void  regist(){}

    @PostMapping("regist")
    public String registMenu(HttpServletRequest request , Model model){
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 "
                + price + "원으로 등록하였습니다.@!!~~";


        model.addAttribute("message", message);

        return "first/messagePrinter";
    }


    @GetMapping("modify")
    public void modify(){
    }

}
