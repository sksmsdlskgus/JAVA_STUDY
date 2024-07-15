package com.ohgiraffers.section02.encapsulation.problem2;

import com.ohgiraffers.section02.encapsulation.problem2.Monster;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 필드값 수정 시 발생할 수 있는 문제점을 이해할 수 있다. */
        Monster monster1 = new Monster();
//        monster1.name = "드라큘라";
//        monster1.hp = 200;

//        System.out.println("monster1 name: " + monster1.name);
//        System.out.println("monster1 hp: " + monster1.hp);

        monster1.setInfo1("프랑켄 슈타인"); //setInfo의 set 함수를 사용함으로 써 여기서는 직접 접근 X
        monster1.setInfo2(200);             // 변수이름이 변경되어도 오류가 Monster클래스에서만 오류남 굿

        /* 설명. 하지만 여전히 직접 접근은 가능한 상태이다. */
        System.out.println(monster1.kinds);
        // 그러면 어케 ? -> 문법적으로 막아함 !!!! -> 캡슐화 적용

    }
}
