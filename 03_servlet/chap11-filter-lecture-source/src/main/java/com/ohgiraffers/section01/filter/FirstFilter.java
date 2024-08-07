package com.ohgiraffers.section01.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/first/*")
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성!!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init 호출!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter doFilter 호출띄");

        /* 설명. FilterChain에서 제공하는 doFilter를 활용하여 다음 필터 또는 서블릿을 진행 시킬 수 있다. */
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("서블릿을 다녀온 후 ");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destory 호출");
    }
}
