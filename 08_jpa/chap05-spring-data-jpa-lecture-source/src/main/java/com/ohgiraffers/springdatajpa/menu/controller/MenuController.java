package com.ohgiraffers.springdatajpa.menu.controller;


import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController {
    private final MenuService menuService;

    /* 설명.
    *   로그 사용 이유?
    *   1. println보다 성능적으로 우수하다.
    *   2. 외부 리소스 파일로 따로 저장 및 송출이 가능하다.
    *   3. 로그레벨에 따른 확인이 가능하다.(개발: debug, 서비스: info 로 자주사용)
    *  */
//    Logger logger = LoggerFactory.getLogger(MenuController.class);
//    Logger logger = LoggerFactory.getLogger(getClass());
    //sout보다 로그로 찍어 출력할 수 있음 권장

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /* 설명. pathVariable 방식으로 menuCode에 url 경로 상의 7을 받아낸다. */
    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {

//        logger.debug("menuCode: {}", menuCode);
        log.debug("findMenuByCode: {}", menuCode);

        MenuDTO menu = menuService.findMenuByCode(menuCode);
        //Service계층에서 엔티티에서 디티오로 변환한걸 얘가 받은거임

        model.addAttribute("menu", menu);
        //main.html 에서 받은 /{menuCode} 번호에 해당하는 메뉴를 출력해줌

        return "menu/detail";

    }

    /* 설명. 페이징 처리 전 */
//    @GetMapping("/list")
//    public String findAllMenuList(Model model) {
//
//        List<MenuDTO> menuDTOList = menuService.findMenuList();
//        model.addAttribute("menuList", menuDTOList);
//        //list.html에서 받은 변수명 menuList를 받아 출력시킴 --> 스크롤 너무길어 -> 페이징처리
//
//
//        return "menu/list";
//    }

    /* 설명. 페이징 처리 후 */
    @GetMapping("/list")
    public String findAllMenuList(@PageableDefault Pageable pageable, Model model) {

        Page<MenuDTO> menuDTOList = menuService.findMenuList(pageable);

        log.debug("조회한 내용 목록 : {}", menuDTOList.getContent());
        log.debug("총 페이지 수 : {}", menuDTOList.getTotalPages());
        log.debug("총 메뉴 수 : {}", menuDTOList.getTotalElements());
        log.debug("해당 페이지에 표시 될 요소 수: {}", menuDTOList.getSize());
        log.debug("해당 페이지에 실제 요소 수 : {}", menuDTOList.getNumberOfElements());
        log.debug("첫 페이지 이후 : {}", menuDTOList.isFirst());
        log.debug("마지막 페이지 여부 : {}", menuDTOList.isLast());
        log.debug("정렬 방식 : {}", menuDTOList.getSort());
        log.debug("여러 페이지 총 현재 페이지 인덱스 : {}", menuDTOList.getNumber());

        /* 설명. 화면에서 페이징 버튼을 그려내기 위해 필요한 재료 준비(모듈화 2개) */

        model.addAttribute("menuList", menuDTOList);
        //list.html에서 받은 변수명 menuList를 받아 출력시킴 --> 스크롤 너무길어 -> 페이징처리


        return "menu/list";
    }

}
