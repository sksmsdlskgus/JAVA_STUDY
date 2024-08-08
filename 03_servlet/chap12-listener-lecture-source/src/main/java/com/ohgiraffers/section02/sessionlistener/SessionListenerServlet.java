package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("서블릿에서 session 출력: " + session.getClass().getName());

        session.setAttribute("userName","leenazzang");
        session.setAttribute("age",23);
        session.setAttribute("gender","W");

        session.setAttribute("userName","lee");
        session.setAttribute("user",new UserDTO("leenazzang",23));

        session.removeAttribute("user");
        session.invalidate();
    }
}
