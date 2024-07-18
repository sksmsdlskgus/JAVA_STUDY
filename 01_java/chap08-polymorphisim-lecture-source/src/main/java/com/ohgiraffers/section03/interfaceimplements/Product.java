package com.ohgiraffers.section03.interfaceimplements;

import java.io.Serializable; //입출력 관련 도구모음

public class Product implements InterProduct, Serializable {
    @Override
    public void nonStaticMethod() {
        System.out.println("InterProduct와 nonStaticMethod 오버라이딩 메소드 호출됨...");

    }


}
