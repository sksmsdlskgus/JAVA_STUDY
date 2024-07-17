package com.ohgiraffers.section02.abstractclass;

public class SmartPhone extends Product{

    public SmartPhone(){

        /* 설명. 추상클래스라도 자식 객체를 위해서는 객체가 생성된다. */
        super();
    }
    /* 설명. 추상메소드를 물려받은 자식 클래스(온전한)는 반드시 오버라이딩 해야한다.(강제성 부여, 규약) */
    @Override
    public void abstractMethod(){
        System.out.println("Product 클래스로부터 물려받은 abstractMethod를 오버라이딩한 메소드 호출됨...");
    }

    public void printSmartphone(){
        System.out.println("SmartPhone 클래스의 printSmartPhone 메소드 호출함...");
    }
}
