package com.ohgiraffers.section03;

import com.ohgiraffers.section02.update.MenuService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴 번호를 입력하세요: ");
        int menuCode = sc.nextInt();

        Menu deleteMenu = new Menu(menuCode);
        MenuService service = new MenuService();
        service.deleteMenu(deleteMenu);

    }
}
