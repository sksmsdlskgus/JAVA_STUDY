package com.ohgiraffers.springdatajpa.common;

import org.springframework.data.domain.Page;

public class Pagination {

    /* 설명. PagingButtonInfo(버튼 생성에 필요한 정보)를 생성해 반환하는 static 메소드 */
    public static PagingButtonInfo getPagingButtonInfo(Page page) {

        int currentPage = page.getNumber() + 1;     // 인덱스 개념 -> 실제 보일 페이지 번호의 개념으로 변경
        int defaultButtonCount = 10;                // 한 페이지에 보일 버튼 최대 갯수
        int startPage = 1;                              // 한 페이지에 보여질 첫 버튼
        int endPage = 10;                                // 한 페이지에 보여질 마지막 버튼


        return new PagingButtonInfo(currentPage, startPage, endPage);
    }
}