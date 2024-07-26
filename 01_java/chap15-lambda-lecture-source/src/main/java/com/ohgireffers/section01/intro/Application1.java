package com.ohgireffers.section01.intro;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 람다식에 대해 이해하고 활용할 수 있다. (feat.FunctionalInterface) */


        /* 필기. 1.인터페이스를 구현한 구현테 (Impl클래스)를 이용한 방식(동적바인딩을 활용한 메소드 호출)  */
        Calculator c1 = new CalculatorImpl();
        System.out.println("10과 20의 합은: " + c1.sumTwoNumbers(10, 20));

        /* 필기. 2. 익명클래스를 활용한 방식(인터페이스의 하위 구현체) */
        Calculator c2 = new Calculator(){

            @Override
            public int sumTwoNumbers(int first, int second) {
                return first + second;
            }
        };
        System.out.println("10과 20의 합은: " + c2.sumTwoNumbers(10,20));

        /* 필기. 3. 람다식을 활용한 방식 */
        /* 설명.
        *   람다식은 익명함수로 이름을 별도로 작성하지 않지만 인터페이스의 하위 구현체를 생성하며 유일하게 있는 추상메소드를
        *    오버라이딩 하는 개념이기 때문에 익명함수가 가능하다.
        *    즉, 람다식을 활용하기 위한 인터페이스는 추상메소드를 단 하나만 가져야 한다. 그런 인터페이스를 FuntionalInterface라고 한다.*/
//        Calculator c3 = (x, y) -> {return x * y;};
        Calculator c3 = (x, y) -> x * y;
        System.out.println("10과 20의 합은: " + c3.sumTwoNumbers(10,20));



    }
}
