package com.ohgiraffers.section03.grammer;

public enum UserRole1 {
    GUEST,
    CONSUMER,
    PRODUCER,
    ADMIN;

    /* 설명. 단순한 메소드 하나 추가해보기 */
    public String getNameToLowerCase() {
        return this.name().toLowerCase();
    }
}
