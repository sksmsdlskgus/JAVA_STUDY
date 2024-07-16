package com.ohgiraffers.section08.uses;


/* 설명. 데이터베이스와 직접적으로 연관된 클래스 */
public class MemberRepository {

    /* 설명. static 변수 선언으로 Member 객체를 담는 배열을 데이터베이스로 취급하자. */
    private final static Member[] members = new Member[10];
    private static int count;

    public static boolean store(Member[] newMembers) {
        for (int i = 0; i < newMembers.length; i++) {
            members[count++] = newMembers[i];
        }
        return true;
    }

    public static Member[] findAllMember() {
        return members;
    }
}
