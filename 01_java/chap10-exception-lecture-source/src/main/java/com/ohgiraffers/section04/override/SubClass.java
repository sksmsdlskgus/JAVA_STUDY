package com.ohgiraffers.section04.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends SuperClass {

    /* 설명. 부모 메소드의 예외와 같은 범위 처리(pass) */
//    @Override
//    public void method() throws IOException{
//
//    }


    /* 설명. 부모 메소드와 달리 예외를 발생시키지 않는다면(pass) */
//    @Override
//    public void method() {
//    }

    /* 설명. 부모 메소드 보다 더 낮은(적은) 범위의 예외 발생(pass) */
//     @Override
//    public void method() throws FileNotFoundException {
//    }


    /* 설명. 부모의 메소드보다 상위 타입의 예외 발생 (fail) - 컴파일 에러발생 */
//    @Override
//    public void method() throws Exception {
//
//    }


}
