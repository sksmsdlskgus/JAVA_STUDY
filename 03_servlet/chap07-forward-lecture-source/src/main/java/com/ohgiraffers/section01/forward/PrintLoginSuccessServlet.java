package com.ohgiraffers.section01.forward;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 여기서 req는 두개의 요청과 한개의 속성을 담음  ----> DB까지 다녀와서 새로고침 시 주기적으로 출력
        System.out.println("=======포워딩 된 서블릿에서 넘겨받은 request 객체에 담긴 값 확인 ===");
        System.out.println("이름: " + req.getAttribute("userName"));
        System.out.println("아이디: " + req.getParameter("userId"));
        System.out.println("패스워드: " + req.getParameter("password"));

        String userName = (String) req.getAttribute("userName");

        StringBuilder responseText = new StringBuilder();
        responseText.append("<h3 align=\"center\">")
                .append(userName)
                .append("님 환영합니다.</h3>");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();


    }
}
