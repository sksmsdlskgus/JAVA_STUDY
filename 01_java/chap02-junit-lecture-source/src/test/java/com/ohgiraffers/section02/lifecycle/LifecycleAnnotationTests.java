package com.ohgiraffers.section02.lifecycle;

import org.junit.jupiter.api.*;

public class LifecycleAnnotationTests {

    /* 수업목표. 테스트 메쇼드의 실행 전 후에 동작하는 어노테이션을 사용할 수 있다. */

    @BeforeAll
    public static void beforeAll() {  // 모든 테스트 전에 한 번 실행
        System.out.println("beforeAll");
    }

    @BeforeEach
    public void beforeEach() {  // 각 테스트 전에 실행
        System.out.println("beforeEach");
    }

    @Test
    public void test1() {  // 테스트 메소드 1
        System.out.println("test1");
    }

    @Test
    public void test2() {  // 테스트 메소드 2
        System.out.println("test2");
    }

    @AfterEach
    public void afterEach() {  // 각 테스트 후에 실행
        System.out.println("afterEach");
    }

    @AfterAll
    public static void afterAll() {  // 모든 테스트 후에 한 번 실행
        System.out.println("afterAll");
    }



}
