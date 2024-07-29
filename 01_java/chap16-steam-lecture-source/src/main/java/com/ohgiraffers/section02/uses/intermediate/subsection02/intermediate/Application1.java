package com.ohgiraffers.section02.uses.intermediate.subsection02.intermediate;

import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 중계연산 중 하나인 filter에 대해 이해하고 사용할 수 있다.*/
        /* 필기. 중계 연산: Stream을 반환하며 Stream 관련 멧고드 체이닝이 이어진다.*/

        /* 설명. 필터는 스트림에서 특정 데이터만을 걸러내기 위한 메소드이다. */
        IntStream intStream = IntStream.range(0,10);
        intStream.filter(i-> i% 2 == 0).forEach(i-> System.out.print(i + " "));
    }
}
