package com.ohgiraffers.section02.uses.subsection03.terminal;


import com.ohgiraffers.section02.uses.subsection03.terminal.terminal.Member;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 최종 연산 중 하나인 Collect에 대해 이해하고 사용할 수 있다. */
        /* 필기.
        *   collect()는 Collector 객체에서 제공하는 정적 메소드를 사용할 수 있고 해당 메소드들을 통해
        *   일반적으로 컬렉션(List,Set,Map)을 출력으로 받을 수 있다. */
        List<Member>memberList = Arrays.asList(
                new Member("test01","testName01"),
                new Member("test02","testName02"),
                new Member("test03","testName03")
        );


        List<String> collectorCollection = memberList.stream()
                .map(Member::getMemberName)
                .collect(Collectors.toList());
        collectorCollection.forEach(System.out::println);

        /* 설명. joining()은 요소들을 하나로 합쳐서 하나의 문자열로 바꿔주는 메소드 이다. */
        String str = memberList.stream().map(Member::getMemberName)
                .collect(Collectors.joining());
        System.out.println("str = " + str);

        String str2 = memberList.stream().map(Member::getMemberName)
                .collect(Collectors.joining("||","**",  "!!"));
        System.out.println("str2 = " + str2);


    }
}
