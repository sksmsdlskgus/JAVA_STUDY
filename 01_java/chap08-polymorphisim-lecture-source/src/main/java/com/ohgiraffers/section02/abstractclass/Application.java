package com.ohgiraffers.section02.abstractclass;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 추상클래스와 추상메소드에 대해 이해할 수 있다. */
        /* 필기.
        *   추상클래스와 추상메소드
        *    추상메소드를 0개 이상 포함하는 클래스를 추상클래스라고 한다.
        *    쉽게 말해 불완전한 믈래스라고 생각할 수 있다.
        *    불완전한 클래스는 별도로 생성자를 통해 객체를 생성하지 못한다.
        *    (단, 자식 클래스의 객체가 생성될때는 내부적으로 생성될 수 있다.)
        *
        *
        * 필기.
        *   메소드의 헤드(head)부만 있고 바디(body)부가 없는 메소드를 추상메소드라고 한다.
        *   쉽게 말해 불완전한 메소드라고 생각할 수 있다.
        *   불완전한 메소드를 하나라도 가진 클래스는 반드시 추상클래스가 되어야 한다.
        *    ex) public abstract void method(); */
        
//        Product product = new Product(); 추클은 객체생성 X

        /* 설명. abstract 메소드를 구현한 온전한 자식 클래스는 인스턴스(객체)를 생성할 수 있다. */
        SmartPhone smartPhone = new SmartPhone();
        Product smartPhone2 = new  SmartPhone();  // 추상 클래스도 다형성 적용됨(타입은 물려준다.)
        smartPhone.abstractMethod();
        smartPhone2.abstractMethod(); // 동적 바인딩에 의한 자식 클래스의 오버라이딩 메소드 실행



    }

}
