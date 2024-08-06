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


    }
}
