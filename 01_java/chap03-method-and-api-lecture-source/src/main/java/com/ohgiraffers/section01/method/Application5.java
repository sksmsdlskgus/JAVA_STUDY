package com.ohgiraffers.section01.method;

public class Application5 {
    public static void main(String[] args) {

        /* 수업목표. 메소드 리턴에 대해 이해할 수 있다. */
        Application5 app5 = new Application5();
        app5.testMethod();


    }

    public void testMethod(){
        System.out.println("testMethod() 동작 확인..");


        /* 설명. 메소드를 호출한 곳으로 돌아가기 위해 return;을 작성하며 안 적어도 자동 작성된다. */
        return;
    }
}
