package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        MemberDTO member = context.getBean("memberGenerator",MemberDTO.class);
        System.out.println("member = " + member);
        System.out.println("member.getPersonalAccount() = " + member.getPersonalAccount());

        System.out.println("입금: " + member.getPersonalAccount().deposit(1000000000));
        System.out.println("출금: " + member.getPersonalAccount().withdraw(400000));
        System.out.println("잔액확인: " + member.getPersonalAccount().getBalance());

    }
}
