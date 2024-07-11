package com.ohgiraffers.section01.arithmatic;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 산술연산자에 대해 이해하고 활용할 수 있다. */
        int num1 = 20;
        int num2 = 7;

        System.out.println("num1 + num2 = " + (num1 + num2));
        System.out.println("num1 - num2 = " + (num1 - num2));
        System.out.println("num1 * num2 = " + (num1 * num2));

        double testNum = num1/(double)num2;
        System.out.println("testNum = " + testNum);

        /* 설명. 소수점 이하 세자리까지 표현해보기 */
        double resultNum = (int)(testNum * 1000)/(double)1000;
        System.out.println("resultNum = " + resultNum);
        System.out.println("num1 % num2 = " + (num1 % num2));


    }
}
