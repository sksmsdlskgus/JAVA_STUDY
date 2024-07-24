package com.ohgiraffers.section02.enumtype;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 열거형(enum)을 이용하여 열거 패턴의 단점을 해결하는것을 이해할 수 있다. */
        Subjects subject1 = Subjects.JAVA;
        // 이 객체를 호출하는 순간 enum의 타입 갯수만큼 기본생성자가 호출됨
        Subjects subject2 = Subjects.HTML;  //---> 처음 생성한 객체만 적용 싱글톤 ㄴㅇㅅ
        Subjects subject3 = Subjects.JAVA; //다른 변수에 담으면 같으면 싱글톤


        /* 설명.
        *   1. 열거 타입으로 선언된 인스턴스는 싱글톤으로 관리되며 인스턴스가 각각 한개임을 보장한다.
        *      작성한 순서에 따라 각각은 다른 인스턴스가 생성되며 최초 호출 시에 enum의 생성자를 활용해
        *      생성된다. (lazy singleton 개념)
        *    */
        // 무조건 다른 과목이라고 보장 가능 자료형이 아니라 타입이라서 .
        if(subject1 == subject2){
            System.out.println("두 과목은 같은 과목이다.");
        }else {
            System.out.println("서로 다른 과목이다.");
        }

        /* 설명. 2. 단일 인스턴스임을 보장하기에 == 비교가 가능하다.(동인 객체비교가 가능하다.) */
        if(subject1 == subject3){
            System.out.println("싱글톤이다.");
        }

        /* 설명. 3. 오버라이딩 되지 않은 toStrind() 또는 name()메소드를 활용하여 필드명을 문자열로 변경하기 쉽다. (feat.swtich안씀)*/
        System.out.println(Subjects.JAVA.toString()); //오버라이딩해서 뭘 할 수 있음
        // 내가 재정의 할 수 있다.
        System.out.println(Subjects.JAVA.name()); //이름 그대로 뽑음

        /* 설명. 4. values()를 이용하여 상수값 배열을 반환받고 이를 활용하여 연속처리를 해줄 수 있다. */
        Subjects[] subjects = Subjects.values();
        for(Subjects sub: subjects){
            System.out.println(sub.toString());
            System.out.println(sub.ordinal());
            System.out.println(sub.name());
        }
        
        /* 설명. 5. 타입 안전성을 보장한다. */
        printSubjects(Subjects.JAVA);
//        printSubjects(0);     //Subjects 타입이 아니라서 에러발생


    }

    private static void printSubjects(Subjects subjects) {
    }
}
