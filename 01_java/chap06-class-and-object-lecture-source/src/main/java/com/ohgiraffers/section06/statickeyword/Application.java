package com.ohgiraffers.section06.statickeyword;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. static 키워드에 대해 이해할 수 있다. */
        /* 필기.
        *   static
        *   : 프로그램이 실행될 때 정적 메모리 영역 (static 영역 또는 클래스 영역)에 할당하는 키워드이다.
        *     여러 인스턴스가 공유해서 사용할 목적의 공간이다.
        *      대표적인 예로 싱글톤(singleton) 객체가 있다.*/

//        non-static 필드는 각 객체 인스턴스에 속하며, 객체가 생성될 때마다 초기화됩니다.
//        static 필드는 클래스에 속하며, 모든 객체 인스턴스가 공유합니다.
//        static 필드나 메서드는 인스턴스를 생성하지 않고 클래스 이름으로 접근할 수 있습니다.

        StaticTest st1 = new StaticTest();

        /* 설명. 현재 두 필드가 가지고 있는 값 확인 */
        System.out.println("non-static field: " + st1.getNonStaticCount());
        System.out.println("static field: " + StaticTest.getStaticCount());

        /* 설명. 각 필드 값들을 하나씩 증가 */
        st1.incrementNonStaticCount();
        StaticTest.incrementStaticCount();

        /* 설명. 두 필드 값 확인 */
        System.out.println("non-static field: " + st1.getNonStaticCount());
        System.out.println("static field: " + StaticTest.getStaticCount());

        /* 설명. 새로운 객체 생성 */
        StaticTest st2 = new StaticTest();
        System.out.println("non-static field: " + st2.getNonStaticCount());
        System.out.println("static field: " + StaticTest.getStaticCount());


    }
}
