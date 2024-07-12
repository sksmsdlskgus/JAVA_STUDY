package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class D_swtich {
    public static void testSimpleSwitchStatement() {
        Scanner sc = new Scanner(System.in);
        char grade = sc.next().charAt(0);

        int point = 0;
        boolean flag = true;

        switch (grade) {
            case 'G': point += 10;
            case 'S': point += 10;
            case 'B': point += 10;
                      break;
            default:
                flag = false;
                System.out.println("똑바로 입력 좀 합시다!~");

        }

        /* 설명. G/S/B중에 하나만 입력하면 해당 등급의 point를 보여주고 그렇지 않으면 회원가입 유도 */
//        if (grade == 'G' || grade == 'S' || grade =='B'){
        if (flag){
            System.out.println("당신의 등급은"+ grade +"이며, 현재 포인트는 "+ point +"입니다.");
        } else {
            System.out.println("그럼 이참에 회원가입 고고씽!");
        }

    }

}
