package com.ohgiraffers.section06.statickeyword;

public class StaticTest {
    private  int nonStaticCount;  // 인스턴스 필드
    private static int staticCount; // 클래스 필드 (static 필드)

    public StaticTest() {}

    // 인스턴스 필드의 getter
    public int getNonStaticCount() {
        return nonStaticCount;
    }

    // static 필드의 getter
    public static int getStaticCount() {
        return staticCount;
    }

    // 인스턴스 필드 증가 메소드
    public void incrementNonStaticCount() {
        this.nonStaticCount++;
    }

    // static 필드 증가 메소드
    public static void incrementStaticCount() {
        staticCount++;
    }
}
