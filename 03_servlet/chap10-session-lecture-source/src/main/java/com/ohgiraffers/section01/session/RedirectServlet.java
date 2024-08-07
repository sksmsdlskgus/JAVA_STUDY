package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String firstName = (String) session.getAttribute("firstName"); //(String) 으로 다운캐스팅 필수
        String lastName = (String) session.getAttribute("lastName");

        StringBuilder response = new StringBuilder();
        response.append("<h3> your firstName is")
                .append(firstName)
                .append("\n and lastName is")
                .append(lastName)
                .append("</h3>");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.print(response);
        out.flush();
        out.close();


    }
}
