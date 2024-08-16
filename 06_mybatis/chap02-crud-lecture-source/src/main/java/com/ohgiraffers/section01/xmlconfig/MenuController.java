package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void findAllMenus() {
        List<MenuDTO> menuList = menuService.findAllMenus();

        if(!menuList.isEmpty()) {
            printResult.printMenus(menuList);
        } else {
            printResult.printErrorMessage("조회할 메뉴가 없습니다.");
        }
    }

    public void findMenuByMenuCode(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));
        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if (menu != null) { //메뉴가 이상하다면 ?
            printResult.printMenu(menu);
        }else {
            printResult.printErrorMessage(menuCode + "번의 메뉴는 없습니다.");
        }

    }
}