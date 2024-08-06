package com.ohgiraffers.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {
//    extends HttpServlet를 상속 받으면 요청을 받을 수 있는 메소드가됨

    /* 설명. 기본 생성자 */
    public LifeCycleTestServlet() {
        System.out.println("xml 방식 기본 생성자 실행!");
    }// 서버 킬 시

    /* 설명. 서블릿의 요청이 최초인 경우 서블릿 객체를 생성하고 자동으로 호출하게 되는 메소드 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 init()메소드 호출!!");
    } // /xml-lifecycle 링크 클릭 시


    /* 설명.
    *   서블릿 컨테이너에 의해 호출되며 최초 요헝 시에만 init() 이후에 동작하고,
    *   두 번째 요청부터는 바로 service()만 호출하게 된다. */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("xml 매핑 service()메소드 호출!!");
        System.out.println("실제로는 요청에 따라 doGet() 또는 doPost()가 실행됨!!");
    }// /xml-lifecycle 링크 클릭 시, 새로고침 시


    /* 설명. 컨테이너가 종료될 때 호출하는 메소드이며 주로 자원을 반납하는 용도로 사용된다.  */
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destroy()메소드 호출!!");
    }// 서버 끌 시



}
