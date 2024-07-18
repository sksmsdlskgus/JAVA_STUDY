package com.ohgiraffers.section01.object.run;

import com.ohgiraffers.section01.object.dto.BookDTO;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Object 클래스의 toString(),... 메소드 오버라이딩의 목적을 이해하고 활용할 수 있다.*/
        BookDTO book1 = new BookDTO(1,"홍길동전","허균",50000);
        BookDTO book2 = new BookDTO(2,"목민심서","정약용",30000);
        Object book3 = new BookDTO(3,"칭찬은 고래도 춤추게 한다.","고래",10000);


        System.out.println(book1.toString());
        System.out.println(book2.toString()); // println이 매개변수로 넘어온 참조자료형의 toString()자동 실행
        System.out.println(book3.toString()); // 동적 바인딩에 의한 자식 클래스의 toString()실행


    }
}
