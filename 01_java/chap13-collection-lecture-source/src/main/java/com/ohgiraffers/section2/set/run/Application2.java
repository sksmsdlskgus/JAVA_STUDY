package com.ohgiraffers.section2.set.run;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {
        
        /* 수업목표. LinkedHashSet에 대해 이해하고 활용할 수 있다. */
        /* 필기.
        *   LinkedHashSet은 저장 당시의 순서를 유지하는 특성을 가지고 있다.
        *   (중복 제거 + 순서 유지) */
        Set<String> lSet = new LinkedHashSet<>();
        
        lSet.add("ramen");
        lSet.add("pork");
        lSet.add("kimchi");
        lSet.add("friedEgg");
        lSet.add("soup");

        System.out.println("lSet = " + lSet);

        Iterator<String> it = lSet.iterator();
        //lSet이라는 변수로 명명된 집합(Set)의 모든 요소를 반복(iterate)하면서 각 요소를 출력
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
