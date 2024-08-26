package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.common.Pagination;
import com.ohgiraffers.springdatajpa.common.PagingButtonInfo;
import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController {

    private final MenuService menuService;

    /* 설명.
     *  로그 사용 이유?
     *   1. println보다 성능적으로 우수하다.
     *   2. 외부 리소스 파일로 따로 저장 및 송출이 가능하다.
     *   3. 로그레벨에 따른 확인이 가능하다.(개발: debug, 서비스: info)
     * */
//    Logger logger = LoggerFactory.getLogger(MenuController.class);
//    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /* 설명. pathVariable 방식으로 menuCode에 url 경로 상의 7을 받아낸다. */
    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
//        logger.debug("menuCode: {}", menuCode);
        log.debug("menuCode: {}", menuCode);

        MenuDTO menu = menuService.findMenuByCode(menuCode);

        model.addAttribute("menu", menu);

        return "menu/detail";
    }

    /* 설명. 페이징 처리 전 */
//    @GetMapping("/list")
//    public String findMenuList(Model model) {
//
//        List<MenuDTO> menuDTOList = menuService.findMenuList();
//        model.addAttribute("menuList", menuDTOList);
//
//        return "menu/list";
//    }

    /* 설명. 페이징 처리 후 */
    @GetMapping("/list")
    public String findMenuList(@PageableDefault(size=10) Pageable pageable, Model model) {

        Page<MenuDTO> menuDTOList = menuService.findMenuList(pageable);

        log.debug("조회한 내용 목록: {}", menuDTOList.getContent());
        log.debug("총 페이지 수: {}", menuDTOList.getTotalPages());
        log.debug("총 메뉴 수: {}", menuDTOList.getTotalElements());
        log.debug("해당 페이지에 표시 될 요소 수: {}", menuDTOList.getSize());
        log.debug("해당 페이지에 실제 요소 수: {}", menuDTOList.getNumberOfElements());
        log.debug("첫 페이지 여부: {}", menuDTOList.isFirst());
        log.debug("마지막 페이지 여부: {}", menuDTOList.isLast());
        log.debug("정렬 방식: {}", menuDTOList.getSort());
        log.debug("여러 페이지 중 현재 페이지 인덱스: {}", menuDTOList.getNumber());

        /* 설명. 화면에서 페이징 버튼을 그려내기 위해 필요한 재료 준비(모듈화(2개)) */
        PagingButtonInfo paging = Pagination.getPagingButtonInfo(menuDTOList);

        model.addAttribute("menuList", menuDTOList);
        model.addAttribute("paging", paging);

        return "menu/list";
    }

    @GetMapping("/querymethod")
    public void queryMethodPage() {}

    @GetMapping("/search")
    public String findMenuPrice(@RequestParam int menuPrice, Model model) {
        List<MenuDTO> menuList = menuService.findMenuPrice(menuPrice);

        model.addAttribute("menuPrice", menuPrice);
        model.addAttribute("menuList", menuList);
        return "menu/searchResult";
    }

    @GetMapping("/regist")
    public void registPage() {}

    /* 설명. regist.html에서 넘어오는 비동기 요청에 대해 json 문자열을 반환하는 핸들러 메소드 */
    @GetMapping(value="/category", produces = "application/json; charset=UTF-8")

    /* 설명.
     *  메소드에 @ResponseBody가 붙은 메소드의 반환형은 ViewResolver가 해석하지 않는다.
     *  @ResponseBody가 붙었을 때 기존과 다른 핸들러 메소드의 차이점
     *   1. 핸들러 메소드의 반환형이 어떤 것이라도 상관 없다.
     *      (모두 json 문자열 형태로 요청이 들어온 곳으로 반환된다.)
     *   2. 한글이 포함된 데이터는 produces속성에 'application/json'라는 MIME 타입과
     *      'charset=UTF-8'인코딩 타입을 붙여준다.
     *      (현재 우리버전은 필수가 아니지만 더 낮은 버전에선 한글이 깨지면 추가한다.)
     * */
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        return menuService.findAllCategory();
    }

    @PostMapping("/regist")
    public String regist(MenuDTO newMenu) {
//        log.debug("newMenu: {}", newMenu);

        menuService.registMenu(newMenu);

        return "redirect:/menu/list";
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyMenu(MenuDTO modifyMenu) {
        menuService.modifyMenu(modifyMenu);

        return "redirect:/menu/" + modifyMenu.getMenuCode();
    }

    @GetMapping("delete")
    public void deletePage(){}

    @PostMapping("/delete")
    public String deleteMenu(@RequestParam int menuCode){
        menuService.deleteMenu(menuCode);

        return "redirect:/menu/list";
    }
}







