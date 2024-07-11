package com.ohgiraffers.section01.method;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표. 여러 개의 전달인자를 이용한 메소드 호출을 할 수 있다. */
        Application4 app4 = new Application4();
        app4.testMethod("홍길동",20,'남');

        String name1 = "유관순";
        int age = 20;
        char gender = '여';
        app4.testMethod(name1,age,gender);
    }


    public void testMethod(String name, int age, final char gender) {
        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "세이며, 성별은 " + gender + "입니다." );

    }
}
