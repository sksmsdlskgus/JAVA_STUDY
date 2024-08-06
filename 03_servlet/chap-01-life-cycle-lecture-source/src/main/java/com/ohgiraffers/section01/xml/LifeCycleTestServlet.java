package com.ohgiraffers.section01.xml;

import jakarta.servlet.http.HttpServlet;

public class LifeCycleTestServlet extends HttpServlet {
//    extends HttpServlet를 상속 받으면 요청을 받을 수 있는 메소드가됨

    /* 설명. 기본 생성자 */
    public LifeCycleTestServlet() {
        System.out.println("xml 방식 기본 생성자 실행!");
    }
}
