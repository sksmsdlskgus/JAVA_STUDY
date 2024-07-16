package com.ohgiraffers.section04.constructor;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 생성자 함수가 무엇인지 이해하고 선언 및 호출할 수 있다. */

        /* 필기.
        *   생성자란?
        *    인스턴스를 생성할때 호출하는 반환형이 없는 함수로 기본 생성자와 매개변수 있는 생성자로
        *    나눌 수 있다.
        *  */

        User user1 = new User(); // 메소드의 이름과 매개변수 이름과 같게 해야함
                                 // new 뒤에 User(); 부분은 생성자(constructor)라는 메소드를 호출하는 구문
        System.out.println(user1.information()); // 각 변수값 null 확인

        User user2 = new User("user01","pass01","피카츄",new java.util.Date());
        System.out.println(user2.information());

    }
}
