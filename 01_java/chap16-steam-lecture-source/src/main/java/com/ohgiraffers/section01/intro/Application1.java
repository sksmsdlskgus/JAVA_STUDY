package com.ohgiraffers.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Stream에 대해 이해하고 활용할 수 있다.*/
        /* 설명.
        *   Arrays.asList(): 매개변수로 요소들을 전달하면 List로 빈환
        *   ArrayList<>(Collection 타입) : Collection 타입을 Arrat:ist 객체로 */
        List<String> stringList = new ArrayList<>(Arrays.asList("hello","world","stream"));


        System.out.println("=======for each");
        for (String str : stringList) {
            System.out.println(str);
        }

        System.out.println("=======for each");
//         stringList.stream().forEach(x -> System.out::println(x)); // 스트림으로 바뀐 어레이 리스트의 요소들이 각각 람다식에 적용되어 동작한다.
         stringList.stream().forEach(System.out::println); // 이코드를 봣을 때 위와 같은 코드를 유휴가능하면됨
    }
}
