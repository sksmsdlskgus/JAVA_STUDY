package com.ohgiraffers.section03.references;

public class Member {
    private String memId;

    public Member(String memId) {
        this.memId = memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memId='" + memId + '\'' +
                '}';
    }
}
