package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이름: " + req.getParameter("firstName"));
        System.out.println("성: " + req.getParameter("lastName"));

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        /* 설명.
        *   요청이 서블릿으로 들어올때 HttpServletRequest의 header에는 JSESSIONID라는 값이 들어있고
        *   이를 활용해 JSESSIONID별로 HttpSession 객체를 생성해서 해당 사용자를 위한 전용 저장 공간을
        *   제공하게 된다. */
        HttpSession session = req.getSession();
        System.out.println("session의 default 유지시간: " + session.getMaxInactiveInterval()); //30분 안에 짐 못빼면 폐기

        session.setMaxInactiveInterval(60*10); //(초 단위) 10분 이렇게 줄일 수 있음
        System.out.println("Session의 JSESSIONID 확인: " + session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        resp.sendRedirect("redirect");


    }
}
