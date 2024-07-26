package com.ohgiraffers.section03.references;

import java.util.function.Function;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 기존에 존재하는 생성자를 참조한 람다식을 활용할 수 있다. */
        Function<String, Member> constMember = (str) -> {return new Member(str);};
//        Function<String, Member> constMember = Member::new;

        Member member1 = constMember.apply("Lambda A");
        System.out.println("member1 = " + member1);

        Member member2 = constMember.apply("Lambda B");
        System.out.println("member2 = " + member2);

    }
}
