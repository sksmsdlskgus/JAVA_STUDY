package com.ohgiraffers.section04.testapp.repository;

import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {

    private ArrayList<Member> memberList = new ArrayList<>(); // member객체들을 담는 ArrayList생성


    /* 설명.
    *    최초에 생성될 객체의 생성자
    *    1. 초기 회원 3명을 넣어둘 예정 (스트림을 활용한 객체 출력)
    *    2. 파일로부터 회원정보를 가져온다.(스트림을 사용한 객체 입력)
    *    3. ArrayList를 활용해 가져온 회원 정보를 저장
    *
    * */
    //생성자 호출되는지
    public MemberRepository(){ // 회원 3명 담기
        File file = new File("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat"); // db안에 파일생성할것임
        ArrayList<Member> defaultmembers = new ArrayList<>(); //초기 회원 세명만 담는용도의 ArrayList(지역변수) 여기서만 잠깐 쓰는 용도로 List하나 더 생성
        defaultmembers.add(new Member(1,"user01","pass01",20, new String[]{"발레","수영"}, BloodType.A));
        defaultmembers.add(new Member(2,"user02","pass02",10, new String[]{"게임","영화시청"}, BloodType.B));
        defaultmembers.add(new Member(3,"user03","pass03",15, new String[]{"음악감상","독서","명상"}, BloodType.O));


        /* 설명. 초기 멤버 3명을 파일로 객체 출력하는 코드 작성 */
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            /* 설명. 초기 회원 3명을 각각 객체 출력 내보냐기 */
        for (Member member : defaultmembers) { // 한명씩 꺼내
            oos.writeObject(member);
        }

        } catch (IOException e) { // 예외처리
            throw new RuntimeException(e);
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
