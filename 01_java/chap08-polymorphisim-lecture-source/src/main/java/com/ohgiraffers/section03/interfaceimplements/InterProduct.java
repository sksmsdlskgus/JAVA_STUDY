package com.ohgiraffers.section03.interfaceimplements;

public interface InterProduct extends ParentInterProduct,AnotherParentInterProduct {

//    pulbic static final int MAX_NUM = 100;

    int MAX_NUM = 100;         // 상품은 최대 100개만 저장 가능하고 이 값을 활용해라.
//    private static final int MAX_NUM = 100; -> 다르게 변형해서 쓸 수 없다.

    /* 설명. 인터페이스는 생성자를 가질 수 없다. */
//    public InterProduct(){}

    /* 설명. 기본적으로 추상메소드만 가능하다. */
//    private void nonStaticMethod();   public abstract만 가능
//    public abstract void nonStaticMethod(); 가능
     void nonStaticMethod();        //생략 가능


    /* 설명. static 메소드는 바디부까지 작성을 허용한다. ( JDK 1.8부터 추가되 기능 ) */
    public static void staticMethod() {}

    /* 설명. non-static 메소드라도 default 키워드를 추가하면 바디부까지 작성을 허용했다.  ( JDK 1.8부터 추가되 기능 ) */
    public default void defaultmethod() {}


    /* 설명. private도 abstract가 아닌 온전한 메소드로 사용은 가능하다. (default도 없이) */
    private void privateMethod() {}

        /* 설명. 다른 public default 메소드에서 활용할 수만 있는 기능 */

}


