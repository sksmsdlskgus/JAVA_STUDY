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

    public void findAllMemberBy(int memNo) {
      Member selectedMember =  mr.selectMemberBy(memNo);

      if(selectedMember != null) {
          System.out.println("조회된 회원은:  " + selectedMember.getId() + " 아이디 회원");
      }else {
          System.out.println("그런 회원은 없네요!~ ");
      }
    }

    public void registMember(Member newMember) {

        int lastMemberNo = mr.selectLastMemberNo();
        newMember.setMemNo((lastMemberNo + 1));

      int result =  mr.insertMember(newMember);
//        System.out.println("성공실패 유무 확인: " + result);
        if(result == 1) {
            System.out.println(newMember.getId() + "님 회원가입 해 주셔서 감사합니다.");

            /* 설명. JABC 이후에는 comit/rollback 처리도 할 예정 */
        }

    }

    public void removeMember(int removeMember) {
        int result = mr.deleteMember(removeMember);
        if(result == 1) {
            System.out.println("다시 돌아오세요 !~");
            return;
        }
        System.out.println("회원 번호 틀렸나 본데요?");
    }


    public void modifyMember(int chooseinfo) {

    }
}
