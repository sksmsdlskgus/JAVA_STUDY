package com.ohgiraffers.section02.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("section02/xmlconfig/spring-context.xml");
        //xml파일에서 bean설정 등록한것을 가져올 경로 설정해서 콩의 객체를 출력해보자

        MemberDTO member2 = (MemberDTO) context.getBean("member2");
        System.out.println("member2 = " + member2);
        //member2 = MemberDTO(sequence=2, id=user02, pwd=pass01, name=이나짱)

    }
}
