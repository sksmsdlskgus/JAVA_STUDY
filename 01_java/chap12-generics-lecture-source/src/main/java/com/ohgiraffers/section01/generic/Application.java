package com.ohgiraffers.section01.generic;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 제네릭(generic)에 대해 이해할 수 있다. */
        MyGenericTest mgt = new MyGenericTest();

        mgt.setValue("Hello World");
        mgt.setValue(1);
        mgt.setValue(3.14);

        System.out.println(mgt.getValue());
        Object result = mgt.getValue();
        String primitiveResult = (String)result;
        // (Double)형으로 다운캐스팅을 해야하지만
        // (String)으로 다운캐스팅도 컴파일 시점에 가능해지고 이는 런타임 에러를 발생시킨다.
        // (Object를 홯용하는것은 자료형이 안전하지 않다.)


//        GenericTest<Integer> gt1 = new GenericTest<Integer>();
        GenericTest<Integer> gt1 = new GenericTest<>(); // 객체의 생성자 부분에는 빈 다이아몬드 연산자도 허용 가능

//        String strResult = (String)gt1.getValue(); // 컴파일 시점에 컴파일 에러로 인해 타입을 체크할 수 있다.
        int inResult = gt1.getValue();              // 다운 캐스팅을 고려하지 않아도 된다.

//        gt1.setValue("");
        gt1.setValue(10);

        /* 필기.
        *   제네릭 클래스는 다양한 자료형으로 변할 수 있어 클래스 하나만으로 활용가치가 높아진다. (구현의 편의성)
        *   매개변수나 반환형도 제네릭 타입으로 지정되어 있어 명확히 해당 타입에 대해 처리 할 수 있다.(타입의 안전성)
        * */


    }
}
