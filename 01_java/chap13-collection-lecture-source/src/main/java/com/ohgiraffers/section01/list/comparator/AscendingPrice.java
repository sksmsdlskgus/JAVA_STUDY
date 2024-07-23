package com.ohgiraffers.section01.list.comparator;

import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.Comparator;

public class AscendingPrice implements Comparator<BookDTO> {

    /* 설명. 가격 오름차순이 가능하도록 compare() 메소드 오버라이딩 */
    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
