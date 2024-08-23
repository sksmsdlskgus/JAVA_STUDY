package com.ohgiraffers.springdatajpa.menu.controller;


import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MenuController {
    private final MenuService menuService;

    /* 설명.
    *   로그 사용 이유?
    *   1. println보다 성능적으로 우수하다.
    *   2. 외부 리소스 파일로 따로 저장 및 송출이 가능하다.
    *   3. 로그레벨에 따른 확인이 가능하다.(개발: debug, 서비스: info 로 자주사용)
    *  */
    Logger logger = LoggerFactory.getLogger(MenuController.class);
    //sout보다 로그로 찍어 출력할 수 있음 권장

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /* 설명. pathVariable 방식으로 menuCode에 url 경로 상의 7을 받아낸다. */
    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable String menuCode) {

        logger.

        return "menu/detail";

    }

}
