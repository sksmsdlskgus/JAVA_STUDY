package com.ohgiraffers.chap06;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class StopwatchInterceptor implements HandlerInterceptor {

    private final MenuService menuService;

    @Autowired // 인터셉터는 콩을 주입 받을 수 있는 것이 큰 차이점이다.

    public StopwatchInterceptor(final MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        menuService.method();

        System.out.println("preHandle() 호출함...(핸들러 메소드 이전)");
       long startTime = System.currentTimeMillis();
       request.setAttribute("startTime", startTime);


       /* 설명. 반환형을 false로 하면 특정 조건에 의해 이후 핸들러 메소드가 실행되지 않게 할 수도 있다. */
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler 호춣함...(핸들러 메소드 이후)");

        long startTime = (long)request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

        modelAndView.addObject("interval", endTime - startTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
