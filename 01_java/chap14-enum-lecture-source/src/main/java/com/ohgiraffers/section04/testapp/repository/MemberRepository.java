package com.ohgiraffers.section04.testapp.repository;

import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

/* 설명. MemberRepository 역할: 데이터와 입출력(CRUD)을 위해 만들어지며 성공 또는 실패 여부를 반환 */
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
    public MemberRepository() { // 회원 3명 담기
        File file = new File("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat"); // db안에 파일생성할것임
        ArrayList<Member> defaultmembers = new ArrayList<>(); //초기 회원 세명만 담는용도의 ArrayList(지역변수) 여기서만 잠깐 쓰는 용도로 List하나 더 생성

        /* 설명. main을 실행할 때마다 덮어씌우는 문제를 방지하고자 파일이 없을 때만 초기 세팅이 되도록 조건문 작성 */
        if (!file.exists()) {
            defaultmembers.add(new Member(1, "user01", "pass01", 20, new String[]{"발레", "수영"}, BloodType.A));
            defaultmembers.add(new Member(2, "user02", "pass02", 10, new String[]{"게임", "영화시청"}, BloodType.B));
            defaultmembers.add(new Member(3, "user03", "pass03", 15, new String[]{"음악감상", "독서", "명상"}, BloodType.O));


        /* 설명. 초기 멤버 3명을 파일로 객체 출력하는 코드 작성 */
        saveMembers(file, defaultmembers);
        } //꺼도 데이터 저장

        /* 설명. 파일로 부터 회원 객체들을 입력받아 memberList에 쌓기  */
        loadMember(file);

        /* 설명. loadMember()메소드를 통해 잘 불러와 졌는지 확인 */
//        for(Member member :memberList){
//            System.out.println("member = " + member);
//        }
    }


    private void loadMember(File file) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

            while (true) {
                memberList.add((Member) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("회원 정보 모두 로딩됨...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void saveMembers(File file, ArrayList<Member> defaultmembers) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            /* 설명. 초기 회원 3명을 각각 객체 출력 내보내기 */
            for (Member member : defaultmembers) { // 한명씩 꺼내
                oos.writeObject(member);
            }

        } catch (IOException e) { // 예외처리
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Member> selectAllMembers() {
        return memberList;
    }

    public Member selectMemberBy(int memNo) {
        for (Member mem : memberList) { // 성공했으면 반환
            if (mem.getMemNo() == memNo) return mem;
        } // 아니면 null 값 반환
        return null;
    }

    public int insertMember(Member newMember) {
        /* 설명. 객체 파일 출력으로 insert개념을 진행할 떄는 기존 회원에 이어서 출력이 발생해야함(feat.MyObjestOutput) */
        MyObjectOutput moo = null;
        int result = 0; // 초기값을 집어넣고 return

        try {
            moo = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat", true)));

            /* 설명. 파일로 새로운 회원 객체 출력하기(기존 회원에 추가) */
            moo.writeObject(newMember); // 입력한 회원정보를 파일에 넣음
            /* 설명.  파일 출력이 성공하면 회원을 관리하는 컬렉션에도 추가 (최신화)*/
            memberList.add(newMember); // 파일에 넣었으니 컬렉션으로 최신화 해줌

            /* 설명. 객체 한개 insert성공을 의미하는 int값 */
            result = 1; // 회원정보가 최신화 되었다면 성공했다면? 1 반환
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (moo != null) moo.close();
                moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result; // 실패 하면 0 반환
    }


    /* 설명. insert를 하기 위해 회원 번호를 발생시키는데 사용되는 마지막 회원의 번호 추출 기능 메소드  */
    public int selectLastMemberNo() {

        /* 설명. 마지막 회원을 조회해서 그 회원의 회원번호를 확인  (항상 맞지는 X)*/
        Member lastMember = memberList.get(memberList.size() - 1);
        return lastMember.getMemNo();

        /* 설명. 2. 컬렉션의 크기가 곧 회원번호이므로 마지막 회원의 번호는 컬렉션의 크기 (항상 맞지는 X) */
//        return memberList.size();
    }

    public int deleteMember(int removeMember) {

        /* 설명.
         *    현재는 우리가 마지막 회원 번호 추출을 위해 컬렉션의 size()를 활용하고 잇다.
         *   (그래서 hard delete(실제 회원 객체를 제거)를 할 수 없고
         *   soft delete(회원 중에 칼퇴와 관련된 속성 수정)를 진행해야 한다.
         *
         * 설명.
         *    hard delete를 하게 된다면 memberList에서 회원 한명을 remove() 메소드를 활용하여 삭제하고
         *    파일 객체 출력을 통해 파일에 컬렉션에 있는 회원들을 다시 덮어끠워야 하낟.(ObjectOutputStream을 활용해서)
         * */

        /* 설명. soft delte 시  */
//        int result = 0;
//        try {
//            for (Member mem : memberList) {
//                if (mem.getMemNo() == removeMember) {
//                    mem.setId(null);
//                }
//            }
//
//            return 1;
//            return result;


        /* 설명. hard delete시 */
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemNo() == removeMember) {
                memberList.remove(i);

                File file = new File("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat");
                saveMembers(file,memberList);
                /* 설명. 컬렉션의 모든 내용을 파일로 출력(덮어씌우기 */
                return 1;
            }
        }
        return 0;
    }
}
