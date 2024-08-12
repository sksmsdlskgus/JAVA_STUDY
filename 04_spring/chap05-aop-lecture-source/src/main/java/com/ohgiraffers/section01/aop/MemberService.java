package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {


    private final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO) { // final이 있으니까 이런식으로 생성자 주입
        this.memberDAO = memberDAO;
    }

    public List<MemberDTO> findMembers() {
        System.out.println("target -> findAllMembers 실행");
        return memberDAO.selectAllMembers();
    }
}
