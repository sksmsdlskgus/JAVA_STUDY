package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 최종 연산 중 하나인 reduce에 대해 이해하고 사용할 수 있다. */

        /* 설명. 인자가 1개일 경우 */
        OptionalInt reduceOneParam = IntStream.range(1, 4)
                .reduce((a, b) -> Integer.sum(a, b));

        System.out.println("reduceOneParam = " + reduceOneParam.getAsInt());

        /* 설명. 인자가 2개일 경우 */
        int reduceTwoParam = IntStream.range(1,4)
                .reduce(100,Integer::sum);      //identity부터 누적 기작

        System.out.println("reduceTwoParam = " + reduceTwoParam);

        /* 설명. 인자가 3개일 경우 */
        Integer reduceThreParam = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .reduce(100,Integer::sum,(x,y) -> x + y);

        System.out.println("reduceThreParam = " + reduceThreParam);
    }
}
