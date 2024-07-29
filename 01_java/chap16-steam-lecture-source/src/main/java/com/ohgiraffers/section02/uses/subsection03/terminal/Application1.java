package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 최종연산(Terminal Operater) 중 하나인 calculation에 대해 이해하고 사용할 수 있다. */
         /* 필기. 최종 연산: Stream이 아닌 값을 반환하며 Stream이 끝날 때 사용한다. */
        long count = IntStream.range(1,10).count();
        int sum = IntStream.range(1,10).sum();

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);

        /* 설명. OptionalInt는 '결과 없음'을 나타내야 하는 명확한 요구가 있는 메소드 반환 형식으로 사용하기 위한 타입이다. */
        OptionalInt max = IntStream.range(1,10).max();
//        OptionalInt max = IntStream.range(1,1).max();     
//  OptionalInt: 기본자료형도 존재하지 않으면 empty의 개념을 주기위한 타입
        OptionalInt min = IntStream.range(1,10).min();
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        
        
        int oddSum = IntStream.range(1,10)
                .filter(i -> i % 2 ==1)
                .sum();
        System.out.println("oddSum = " + oddSum);
    }
}
