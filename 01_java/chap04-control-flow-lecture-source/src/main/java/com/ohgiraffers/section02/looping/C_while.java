package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class C_while {

    public void testSimpleWhileStatement(){
        int i = 1;
        while (i <= 10) {
            System.out.println("i = " + i);
            i++;
        }
    }

    public void testWhileExample(){
        Scanner sc = new Scanner(System.in);

        char answer = '\0';
        while(!(answer == 'Y' || answer == 'Y')){
            System.out.println("Y또는 Y좀 눌러줄래?");
            answer = sc.next().charAt(0);
        }
        System.out.println("시키는 데로 눌러줘서 갑사합니다.");
    }
}
