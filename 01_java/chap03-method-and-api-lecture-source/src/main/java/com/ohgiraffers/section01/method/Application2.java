package com.ohgiraffers.section01.method;

public class Application2 {
    public static void main(String[] args) {
        System.out.println("main() 시작함...");

       /* 설명. static이 없는 메소드(non-static method)는 해당 클래스를 인지시킨 후 접근해 호출한다. */
        Application2 app = new Application2(); // 이 클래스 전체를 인식해줘 (static안붙은것도)
//        methodA();
        app.methodA(); // 그리고 지정한 변수를 넣어서 호출해줘
        app.methodB();
        app.methodC();

        System.out.println("main() 종료됨...");
    }

    public void methodA(){
        System.out.println("methodA() 호출됨...");
        System.out.println("methodA() 종료됨...");
    }
    public void methodB() {
        System.out.println("methodB() 호출됨...");
        System.out.println("methodB() 종료됨...");
    }

    public void methodC() {
        System.out.println("methodC() 호출됨...");
        System.out.println("methodC() 종료됨...");
    }
}
