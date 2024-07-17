package com.ohgiraffers.section03.overriding;

public class SuperClass {

    /* 수업목표. 오버라이딩(overring)에 대해 이해할 수 있다. */

    public void method(int num){}

    public Object method2(int num){return null;}

    private void privateMethod(){}

    public final void finalMethod(){}

    protected void protectedMethod(){}

    /* 설명. default 접근 제어자는 접근제어자를 쓰지 않는것이다. */
    void defaultMethod(){} //default명시 X
}
