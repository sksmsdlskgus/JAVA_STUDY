package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.Arrays;
import java.util.List;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 최종연산 중 하나인 match에 대해 이해하고 사용할 수 있다. */
        List<String> stringList = Arrays.asList("Java","Spring","SpringBoot");

        boolean anyMath = stringList.stream().anyMatch(str -> str.contains("p"));
        boolean allMath = stringList.stream().allMatch(str -> str.length() > 4);
        boolean noneMath = stringList.stream().noneMatch(str -> str.contains("c"));

        System.out.println("anyMath = " + anyMath);
        System.out.println("allMath = " + allMath);
        System.out.println("noneMath = " + noneMath);

    }
}
