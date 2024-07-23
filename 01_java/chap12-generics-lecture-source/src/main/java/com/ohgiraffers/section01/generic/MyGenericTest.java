package com.ohgiraffers.section01.generic;


/* 설명. 다형성 및 boxing에 의해 어떤 값이든 호환되는 클래스 */
public class MyGenericTest {

    private Object value;

    public MyGenericTest() {}

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
