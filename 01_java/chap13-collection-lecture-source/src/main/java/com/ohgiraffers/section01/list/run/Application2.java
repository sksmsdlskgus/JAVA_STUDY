package com.ohgiraffers.section01.list.run;

import com.ohgiraffers.section01.list.comparator.AscendingPrice;
import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. ArrayList에서 관리되는 자료형의 정렬 기준을 이용할 수 있다. */
        /* 목차. 1. Comparable 인터페이스 구현 방법 활용 */
        List<BookDTO> bookList = new ArrayList<>();
        bookList.add(new BookDTO(1,"홍길동전","허균",50000));
        bookList.add(new BookDTO(2,"목민심서","정약용",30000));
        bookList.add(new BookDTO(3,"동의보감","허준",40000));
        bookList.add(new BookDTO(4,"삼국사기","김부식",46000));
        bookList.add(new BookDTO(5,"삼국유사","일연",58000));

        /* 설명. Collections.sort를 활용한 정렬(Comparable 방식 또는 Comparator 방식) */
//        Collections.sort(bookList);           // Comparable 방식
        Collections.sort(bookList, new AscendingPrice());  // Comparator 방식

        /* 설명. ArrayList가 제공하는 sort를 사용할 수도 있다. (다만 Comparator 기준만 가능) */
        bookList.sort(new AscendingPrice());

        System.out.println(bookList);

        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }


    }
}

