package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {
    @Bean (name="member")
    // 켜는순간 아래의 객체와 메소드를 자동으로 작동하게 해주고 이것을 가지고 콩으로 관리하는것
    public MemberDTO getMemberDTO() {
        return new MemberDTO(1,"user01","pass01","이나짱");
    } // 이걸 콩으로 관리해줘 -> Applicaiton main으로 가자


}
