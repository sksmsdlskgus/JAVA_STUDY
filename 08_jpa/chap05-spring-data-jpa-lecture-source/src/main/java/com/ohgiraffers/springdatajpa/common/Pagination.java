package com.ohgiraffers.springdatajpa.common;

import org.springframework.data.domain.Page;

public class Pagination {

    /* 설명. PagingButtonInfo(버튼 생성에 필요한 정보)를 생성해 반환하는 static 메소드 */
    public static PagingButtonInfo getPagingButtonInfo(Page page) {

        int currentPage = page.getNumber() + 1;     // 인덱스 개념 -> 실제 보일 페이지 번호의 개념으로 변경
        int defaultButtonCount = 10;                // 한 페이지에 보일 버튼 최대 갯수
        int startPage;                              // 한 페이지에 보여질 첫 버튼
        int endPage;                               // 한 페이지에 보여질 마지막 버튼


        startPage = (int)(Math.ceil((double) currentPage / defaultButtonCount) -1) * defaultButtonCount + 1;

        /* 설명. 이후 endPage 선언 부분은 endPage에 대한 예외상황 처리용 코드들 */
        endPage = startPage + defaultButtonCount - 1; // 페이지 수를 꽉 채우지 않는 경우도 있기 때문에 무조건 성립이 아니다.


        if(page.getTotalPages() < endPage)
            endPage = page.getTotalPages();

        /* 설명. 페이지가 없더라도 -> 아예 메뉴가 없거나 10개도 안될 때 */
        if(page.getTotalPages() == 0) // 게시글 없는 경우
            endPage = startPage;


        return new PagingButtonInfo(currentPage, startPage, endPage);
    }
}