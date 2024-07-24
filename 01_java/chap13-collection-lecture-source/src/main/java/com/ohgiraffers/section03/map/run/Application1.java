package com.ohgiraffers.section03.map.run;

import com.ohgiraffers.section01.list.dto.BookDTO;

import javax.xml.crypto.Data;
import java.util.*;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Map의 자료구조에 대해 이해하고 HashMap을 이용할 수 있다. */
        Map<Object, Object> hMap = new HashMap<>();
        hMap.put("one", new Date());
        hMap.put(12, "red apple");
        hMap.put(33, 123);

        System.out.println("키가 \"one\"인 value 값: " + hMap.get("one"));
        System.out.println("Map의 toString(): " + hMap);

        hMap.put(new BookDTO(1, "홍길동전", "허균", 50000), "허균의 홍길동전");
        System.out.println("map의 키 값으로 활용되는 객체를 활용: " + hMap.get(new BookDTO(1, "홍길동전", "허균", 50000)));

        /* 설명. 키 값은 중복되면 안되지만 중복될경우 나중의키와 벨류가 기존의 값을 덮어 씌운다. */
        hMap.put(12, "ornge apple"); // id중복 시, 덮어씌움
        System.out.println("hMap = " + hMap);

        /* 설명. 벨류 값은 중복되어도 상관없이 추가된다. */
        hMap.put(34, 123); // 넣는순서 보장 x
        System.out.println("hMap = " + hMap);

        System.out.println("Map 이 지닌 entry의 수: " + hMap.size());

        System.out.println("34번 키와 관련된 entry 삭제: " + hMap.remove(34));
        System.out.println("삭제 후 entry의 수: " + hMap.size());

        /* 설명. Map을 활용해 보자.(반복하여) */
        Map<String, String> hMap2 = new HashMap<>();
        hMap2.put("one", "java 17");
        hMap2.put("two", "mariaDB 10");
        hMap2.put("tree", "servlet/jsp");
        hMap2.put("four", "springboot 3.0");
        hMap2.put("five", "vue.js");

        System.out.println("hMap2 = " + hMap2);

        /* 목차. 1. KeySet()를 활용한 iterator 반복하기(feat.key값만 set으로 변환하자) */
        Set<String> keys = hMap2.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println("key: " + key + ", value: " + hMap2.get(key));
        }

    }
}
