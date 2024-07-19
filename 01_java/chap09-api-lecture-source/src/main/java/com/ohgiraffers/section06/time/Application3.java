package com.ohgiraffers.section06.time;


import java.time.LocalDateTime;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. time 패키지 클래스를 활용한 뎃셈, 뺄셈 및 불변 특성을 이해할 수 있다. */
        /* 설명. 불변이므로 새로운 객체가 생성되어 주소값이 바뀜 */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("현재시간: " + localDateTime);
        System.out.println("주소값: " + System.identityHashCode(localDateTime));

        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println("30분 후: " + localDateTime2);
        System.out.println("주소값: " + System.identityHashCode(localDateTime2));

        LocalDateTime localDateTime3 = LocalDateTime.now();
        System.out.println("3시간 전: " + localDateTime3);
        System.out.println("주소값: " + System.identityHashCode(localDateTime3));
    }
}
