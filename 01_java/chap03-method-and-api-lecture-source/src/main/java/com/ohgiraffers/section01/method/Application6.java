package com.ohgiraffers.section01.method;

public class Application6 {
    public static void main(String[] args) {
        
        /* 수업목표. 반환값이 있는 메소드를 작성할 수 있다. */
        String result = testMethod();
        System.out.println("result = " + result);

        /* 설명. 따로 굳이 변수에 담을 필요가 없다면 반환값을 바로 활용하는것도 가능하다. */
        System.out.println("result2 = " + testMethod());
    }
    
    public static String testMethod(){
        System.out.println("test() 메소드 실행함...");
        return "test";      // 메소드를 호출한 곳에 String 리터럴 값을 반환
    }
}
