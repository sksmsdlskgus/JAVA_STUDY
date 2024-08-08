package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator(){
        return new PersonalAccount(20,"234-234-54333");
    }

    @Bean
    public MemberDTO memberGenerator(){

        /* 설명. 1. 생성자 주입 */
//        return new MemberDTO(1,"이나짱","010-2222-3333","hong@naver.com",accountGenerator());

        /* 설명. 2.  setter 주입 */
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("John Doe");
        member.setPhone("2020-303030-2020");
        member.setEmail("john@doe.com");
        member.setPersonalAccount(accountGenerator());

        return member;
    }



}
