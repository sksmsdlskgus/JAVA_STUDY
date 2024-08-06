package com.ohgiraffers.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import static java.lang.System.out;

@WebServlet("/header")
public class ResponseHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /* 설명. 서버의 현재시간을 동적 페이지로 만들어 내보내 보자. */
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        long currentTime = System.currentTimeMillis();

        out.print("<h1>" + currentTime + "</h1>");
        out.print("<h1>" + new  java.util.Date(currentTime) + "</h1>");
        out.flush();
        out.close();

        /* 설명. response 객체의 header 값에 대한 키 값과 벨류 값을 한번에 확인해보기 */
        Collection<String> responseHeaders = Collections.list(req.getHeaderNames());
        Iterator<String> iter = responseHeaders.iterator();
        while (iter.hasNext()) {
            String headerName = iter.next();
            out.println(headerName + ": " + req.getHeader(headerName));
        }


    }
}


