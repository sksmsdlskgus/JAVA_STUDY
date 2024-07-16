package com.ohgiraffers.section06.singleton;

public class LazySingleton {

    // 클래스의 유일한 인스턴스를 정적 변수로 선언
    private static LazySingleton lazy;

    // 생성자를 private으로 선언하여 외부에서 인스턴스 생성을 막음
    private LazySingleton() {
        // 초기화 코드 (필요한 경우)
    }

    // 유일한 인스턴스를 반환하는 정적 메소드
    public static LazySingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySingleton();
        }

        return lazy;
    }
}
