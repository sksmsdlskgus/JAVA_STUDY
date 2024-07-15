package com.ohgiraffers.section03.abstraction;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarRacer racer = new CarRacer(); // 이부분의 의미는?
        int input = 0; //while (input != 9); while의 조건을 걸기위해

        do {
            System.out.println("========= 카레이싱 프로그램 =========");
            System.out.println("1. 시동걸기");
            System.out.println("2. 전진");
            System.out.println("3. 정지");
            System.out.println("4. 시동 끄기");
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴선택: ");
            input = sc.nextInt();
            switch (input) {
                case 1: racer.starUp();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 9:
                    System.out.println("프로그램을 종료하겠습니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
            }
        }while (input != 9);

    }
}
