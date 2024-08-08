package com.ohgiraffers.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =  //ContextConfiguration클래스에서 받은 콩을 관리하는 컨테이너야 이게 .
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        // 이제 이 컨테이너에서 콩을 꺼내줘

        String[] beanNames = context.getBeanDefinitionNames();
        // 가지고있는 콩 다 내놔
        for(String beanName : beanNames) { // 자 가지고 있는 콩을 하나씩 꺼내볼게?
            System.out.println("beanName: " + beanName);
        } //-> 작동하면 이미 볶아져있는 콩을 내놓는거임 ㅋㅋ 개쩐다
        // 데 이건 그냥 콩 관리 작동을 보는거지 이걸 직접 명시하진 않아서 알려고 하는거야


    }
}
