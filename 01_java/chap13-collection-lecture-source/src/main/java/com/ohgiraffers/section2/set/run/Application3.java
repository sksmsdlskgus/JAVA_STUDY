package com.ohgiraffers.section2.set.run;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        
        /* 수업목표. TreeSet에 대해 이해하고 활용할 수 있다. */
        /* 설명. Tree구조를 활용해 중복제서 + 정렬을 해준다. */
        Set<String> tSet = new HashSet<String>();
        tSet.add("ramen");
        tSet.add("pork");
        tSet.add("kimchi");
        tSet.add("friedEgg");
        tSet.add("soup");

        System.out.println("tSet = " + tSet);

        /* 설명. 1부터 45까지 난수를 중복되지 않게 발생시키고 정렬까지 적용 */
        Set<Integer> lotto = new TreeSet<>();
        while(lotto.size() < 6){
            lotto.add((int)(Math.random() * 45) + 1);
        }
        System.out.println("lotto = " + lotto);
    }
}
