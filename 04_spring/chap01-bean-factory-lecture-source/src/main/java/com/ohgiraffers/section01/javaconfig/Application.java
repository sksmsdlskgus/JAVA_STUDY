package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
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
        // 직접 컨테이너를 만들일은 전혀 없으니 개념만을 위한 것이다.


        /* 설명. bean의 id(bean의 이름)를 이용해서 bean을 가져오는 방법 */
//        MemberDTO member = (MemberDTO) context.getBean("member");
        // 다운캐스팅을 사용해 member이름의 콩을 뽑는 첫번째 방식

        /* 설명. 2. bean의 클래스 메타 정보(bean의 타입)을 전달하여 가져오는 방법 */
//        MemberDTO member = context.getBean(MemberDTO.class);
        // 메타정보를 활용해 콩 객체 출력하기 두번째 방식인데
        // 얘는 이 타입의 콩이 여러개 있을 경우 위험해서 컬렉션 타입으로 사용해야하는 경우가 있음

        /* 설명. 3. bean의 id와 클래스 메타 정보를 전달하여 가져오는 방법 */
        MemberDTO member = context.getBean("member",MemberDTO.class);
        //얘는 이름과 타입을 다 쥐어줬으니 자동으로 콩의 객체를 출력하게 해달라라는 의미인 3번째 방식이다.
        // 얘는 약간 수동이다.

        System.out.println("member = " + member);
        //member = MemberDTO(sequence=1, id=user01, pwd=pass01, name=이나짱)


    }
}
