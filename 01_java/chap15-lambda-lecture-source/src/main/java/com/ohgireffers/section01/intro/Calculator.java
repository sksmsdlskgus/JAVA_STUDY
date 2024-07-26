package com.ohgireffers.section01.intro;

/* 설명. FunctionalInterface민 람다식으로 적용 가능하다. */
@FunctionalInterface
public interface Calculator {
    int sumTwoNumbers(int first, int second);
    // void test(); // 어노테이션 추가 후레는 추상메소드를 2개이상 가지지 못한다.
}
