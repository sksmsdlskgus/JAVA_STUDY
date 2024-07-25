package com.ohgiraffers.section04.testapp.service;

import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.repository.MemberRepository;

import java.util.ArrayList;


/* 설명. 트렌젝션 처리(성공실패에 따른 commit/rollback) 및 회원관련 비지니스 로직 처리 */
public class MemberService {

    private final MemberRepository mr = new MemberRepository();

    public MemberService() {

    }

    public void findAllMembers() { // 레포 겍체 호출
        ArrayList<Member> findMembers = mr.selectAllMembers();
        for (Member member : findMembers) {
            System.out.println("member = " + member);
        }
    }
}
