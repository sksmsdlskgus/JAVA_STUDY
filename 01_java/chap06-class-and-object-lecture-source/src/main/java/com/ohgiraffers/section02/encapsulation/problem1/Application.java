package com.ohgiraffers.section02.encapsulation.problem1;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 필드에 직접 접근하는 경우 발생할 수 있는 문제점을 이해할 수 있다. */
        /* 설명. monster1 생성 */
        Monster monster1 = new Monster();
        monster1.name = "드라큘라";     // 객체 생성
        monster1.hp = 200;             // 참조연산자(.)를 통해 접근해서 값 대입

        System.out.println("monster1의 이름: " + monster1.name);
        System.out.println("monster1의 체력: " + monster1.hp);

        /* 설명. monster2 생성 (음수 데이터(원치 않는)로 인한 문제 발생) */
        Monster monster2 = new Monster();
        monster2.name = "프랑켄";
        monster2.hp = -200;

        System.out.println("monster2의 이름: " + monster2.name);
        System.out.println("monster2의 체력: " + monster2.hp);


        /* 설명. monster3 생성 */
        /* 설명. 이때는 setHp메소드 내부의 this == monster3 */
        Monster monster3 = new Monster();
        monster3.name = "미라";
        monster3.setHp(-200);
        monster3.setHp(100);
        monster3.setHp(-150);



        System.out.println("monster3의 이름: " + monster3.name);
        System.out.println("monster3의 체력: " + monster3.hp);

    }
}
