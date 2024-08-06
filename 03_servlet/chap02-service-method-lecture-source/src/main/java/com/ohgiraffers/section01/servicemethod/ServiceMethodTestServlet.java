package com.ohgiraffers.section01.servicemethod;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("req = " + req);
        System.out.println("res = " + res);

        HttpServletRequest httpquest = (HttpServletRequest) req;
        HttpServletResponse httpsresponse = ( HttpServletResponse) res;

        String httpMethod = httpquest.getMethod();
        System.out.println("요청 방식 : " + httpMethod);

        if("GET".equals(httpMethod)) { // 널포인터 방지 순서 변환 조건 걸기
            doGet(httpquest, httpsresponse);
        } else if("POST".equals(httpMethod)) {
            doPost(httpquest, httpsresponse);
        }


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get 요청을 처리할 메소드 호출중...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post 요청을 처리할 메소드 호출중...");
    }
}
