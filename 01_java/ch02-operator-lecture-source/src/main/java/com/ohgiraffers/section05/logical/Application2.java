package com.ohgiraffers.section05.logical;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 논리 연산자 활용하기 */
        /* 목차. 1. 1부터 100 사이 값 확인  */
        int num1 = 55;
        int num2 = 101;

        System.out.println((num1 >= 1) && (num1 <= 100));
        System.out.println((num2 >= 1) && (num2 <= 100));


        /* 목차. 2. 영어 대문자인지 확인  */
        char ch1 = 'G';
        char ch2 = 'g';

//        System.out.println("A는 유니코드 번호 몇번이지?" + (int)'A');
//        System.out.println("Z는 유니코드 번호 몇번이지?" + (int)'Z');
//        System.out.println(ch1 >= 65 && ch2 <= 90);
        System.out.println(ch1 >= 'A' && ch2 <= 'Z');   // 문자 대소 비교는 문자로 가능하다.

        /* 목차. 3. 대소문자 상관없이 영문자 'y' 확인 */
        char ch3 = 'Y';
        char ch4 = 'Y';
        System.out.println("y 입력했는지 확인 : " + (ch3 =='y' || ch3 == 'Y'));
        System.out.println("y 입력했는지 확인 : " + (ch4 =='y' || ch4 == 'Y'));





    }
}
