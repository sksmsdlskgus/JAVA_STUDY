package com.ohgiraffers.section01.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId"); //파라미터로 가져와서 id값 담기
        String password = req.getParameter("password");//파라미터로 가져와서 passward값 담기

        System.out.println("userId = " + userId); //userId = 이나짱
        System.out.println("password = " + password); // password = 1234

        /* 설명.
        *   이부분에서는 id와 pwd에 해당하는 user의 정보를 select하고 오는 비지니스 로직 (BL)이
        *   수행되어야한다. (이름을 조회해서 이름을 알게됨)
        *    우리는 제대로 조회가 되었다는 가정하에 'XXX님 환영합니다.'와 같은 메시지를 출력하는
        *    화면을 만들어 응답해 보자 */

        req.setAttribute("userName", "이나짱");

        RequestDispatcher dispatcher = req.getRequestDispatcher("print");
        dispatcher.forward(req, resp); //RequestDispatcher가 제공하는 forward를 사용함
        // 이제 print를 받을 클래스를 만들어주는데 이때 doPost로 던져주었다면 doPost로 받아야함

    }
}

