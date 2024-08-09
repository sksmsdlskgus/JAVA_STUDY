package com.ohgiraffers.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/* 설명.
*   DAO 클래스는 Data Access Object를 줄인말로 Repository 계층과 마찬가지로 java application과
*   Database를 연동시켜 주기 위한 계층을 구분하는 클래스로 활용된다.(controller-service-dao)
*    */

/* 설명.
*   @Repository란?
*   1. @Component 계열로 스프링 컨테이너(IOC컨테이너)가 bean으로 등록하는 클래스에 추가하는 어노테이션이다.
*   2. DAO(또는 Repository) 계층에 MVC 구조에 맞춰 구분하기 위해 추가하는 어노테이션이다.
*      (추가적으로는 DB에서 발생한 에러를 자바의 예외타입으로 바꿔주는 부가 기능이 있다. */
@Repository("na")
//@Component  /// @Component라고 해도 bean으로는 관리 될 수 있다.
public class MemberDAO {
    private final Map<Integer, MemberDTO> memberMap ;
//    private final Map<Integer, MemberDTO> memberMap = new HashMap<>(); 이건..잘안씀음... 이유는... 다음시간에
    // final은 의도했던 걸 확신하려고? 주로 생성자를 통해 초기화 한다는걸 확신하며 필드를 생성한다.
    public MemberDAO() {
        memberMap = new HashMap<>();

        memberMap.put(1,new MemberDTO(1,"user01","pass01","이나짱"));
        memberMap.put(2,new MemberDTO(2,"user02","pass02","현나이"));
    }

    /* 설명. 회원 조회용 메소드 */
    public MemberDTO selectMember(int sequence) {
        return memberMap.get(sequence);
    }

    /* 설명. 회원 가입용 메소드 */
    public int insertMember(MemberDTO registmember) {
        int before = memberMap.size();

        memberMap.put(registmember.getSequence(), registmember);
        int after = memberMap.size();

        return after - before;
    }

}
