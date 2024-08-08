package com.ohgiraffers.section01.contextlistener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    public ContextListener() {

        System.out.println("context listener 인스턴스 생성!");
    }


    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("context attribute added!");
        System.out.println("event.getName() = " + event.getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("context attribute replaced!");    }


    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("context attribute removed!");    }

}
