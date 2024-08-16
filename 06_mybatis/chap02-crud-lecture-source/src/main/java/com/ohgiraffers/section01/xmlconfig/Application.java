package com.ohgiraffers.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        MenuController menuController = new MenuController();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("==== 메뉴 관리 ====");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 관리 번호를 입력하세요: ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    menuController.findAllMenus();
                    break;
                case 2:
                    menuController.findMenuByMenuCode(inputMenuCode());
                    break;
                case 9:
                    System.out.println("프로그램을 종료하겠습니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        } while (true);
    }

    private static Map<String,String> inputMenuCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 코드를 입력하세요: ");
        String menuCode = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("menuCode",menuCode);

        return parameter;
    }
}
