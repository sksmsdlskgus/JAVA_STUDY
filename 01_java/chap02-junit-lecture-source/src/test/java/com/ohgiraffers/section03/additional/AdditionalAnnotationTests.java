package com.ohgiraffers.section03.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class AdditionalAnnotationTests {

    /* 수업목표. Junit5에서 제공하는 메소드 관련 추가 어노테이션을 사용할 수 있다. */
   @Disabled //단위테스트를 블록 상태로 만들자.
   @Test
    public void testIgnore() {

    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testTimeout() throws InterruptedException {
       Thread.sleep(900);  // 통과
//       Thread.sleep(1000);  // 예외발생

    }

    @Test
    @Order(1)   // 작을수록 우선순위가 높다.(먼저 실행된다.)
    public void testFirst(){}

    @Test
    @Order(3)
    public void testThird(){}

    @Test
    @Order(2)
    public void testSecond(){}

    @RepeatedTest(10)  // 같은 단위 반복
    public void testRepeat(){

    }



}
