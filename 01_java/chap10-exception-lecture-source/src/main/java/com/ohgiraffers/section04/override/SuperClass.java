package com.ohgiraffers.section04.override;

import java.io.IOException;

public class SuperClass {
    public void method() throws IOException {
//        SuperClass sc = new SuperClass();


        /* 설명. 다형성 적용 시  */
        SuperClass sc = new SubClass();
        try{

            /* 설명. 동적 바인딩에 의해 자식의 오버라이딩한 메소드가 실행 된다면(동적 바인딩) */
            sc.method();
        } catch(IOException e){     // 부모의 method()만 고려해 ㅇ외처리가 문제 될 수 있다.
            throw new RuntimeException(e);
        }
    }
}
