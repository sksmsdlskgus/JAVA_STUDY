package com.ohgiraffers.section06.singleton;

public class EagerSingleton {

    // 클래스의 유일한 인스턴스를 정적 변수로 선언
    private static EagerSingleton eager = new EagerSingleton();
    // static 붙여서 이거 해석될때 말고는 사용 X

    // 생성자를 private으로 선언하여 외부에서 인스턴스 생성을 막음
    private EagerSingleton() {}
    // private 붙여서 이 클래스 내부에서만 이 생성자를 쓸 수 있다.

    public static EagerSingleton getInstance() {
        return eager;

    }
}
