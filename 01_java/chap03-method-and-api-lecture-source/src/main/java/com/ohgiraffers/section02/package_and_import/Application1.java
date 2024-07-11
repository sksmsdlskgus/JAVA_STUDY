package com.ohgiraffers.section02.package_and_import;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 패키지에 대해 이해할 수 있다. */
        /* 설명.
         *  패키지의 의미
         *  1. 클래스의 소속이 다르다. ( 다른 소속에선 같은 클래스명을 쓸 수 있다.)(feat.Date 자료형)
         *  2. 원래 클래스명의 일부분이다.
         *  3. 경우에 따라 생략이 가능하다. (하지만 자동으로 작성되는 내용이다.) (같은 패키지일 떄는 생략 가능)
         *
         */


        /* 설명. non-static 메소드 호출해 보기 (feat.다른패키지에 있는) */
        com.ohgiraffers.section01.method.Calculator calculator = new com.ohgiraffers.section01.method.Calculator();

        int plusResult = calculator.plusTwoNumbers(100,20);
        System.out.println("100과 20의 합 = " + plusResult);

        /* 설명. static 메소드 호출해 보기 (feat.다른 패키지에 있는) */
        int maxResult = com.ohgiraffers.section01.method.Calculator.maxNumbersOf(100,20);

        System.out.println("두 수 중에 큰 수는 " + maxResult);
    }
}
