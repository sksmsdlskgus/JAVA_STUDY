package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class A_for {
    public void testSimpleForStatement() {

//        동안 (1부터; 10까지; 1씩증가){
//            1부터 10까지 반복하며 출력
//        }

        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }
    }

    public void testForExample1(){


        /* 설명. 변수들에 담긴 값들에 각각 2를 곱하고, 1을 더하여 sum에 누적하기 */
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        int num5 = 5;

        int sum = 0;

        sum += 2 * num1 +1;
        sum += 2 * num2 +1;
        sum += 2 * num3 +1;
        sum += 2 * num4 +1;
        sum += 2 * num5 +1;

        System.out.println("sum = " + sum);

        /* 설명. for문을 통해 개선해보자. */
        int forSum = 0;

        /* 설명. 초기값 0부터일 때 */
//        for (int i= 0; i < 5; i++) {
//            forSum += 2 *(i +1)+1;
//        }

        /* 설명. 초기값 1부터일 때 */
        for (int i = 0; i < 5; i++) {
            forSum += 2 * i + 1;
        }

        System.out.println("forSum = " + forSum);
    }

    public void testForExample2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("limit 값 입력");
        int limit = sc.nextInt();

        int sum = 0;

        for (int i = 0; i < limit; i++) {
            sum += i;
        }

        System.out.println("sum = " + sum);
    }
}
