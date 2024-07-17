package com.ohgiraffers.section02.abstractclass;

public abstract class Product {

    private int nonStaticField;
    private static int staticField;

    public Product() {}

    public void nonStaticMethod(){

    }

    public void staticMethod(){}


    /* 설명. 추상 메소드가 하나 이상 존재하면 해당 클래스는 반드시 추상클래스가 돈다. */
    public abstract void abstractMethod();
    // 자식중에 누군가는 이걸 오버라이딩해서 호출한다.

}
