package com.ohgiraffers.section02.string;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 문자열 객체를 생성하는 다양한 방법을 숙지하고 인스턴스가 생성되는 방식을 이해할 수 있다 */
        /* 필기.
         *  문자열 객체를 만드는 방법
         *  1. "" 리터럴 형태: 동일한 값을 가지는 인스턴스(동등(h, e) 객체)를 단일 인스턴스로 관리한다.
         *                   (singleton 개념, 상수풀(constant pool) 활용)
         *  2. new String("") 형태: 매번 새로운 인스턴스를 생성한다.(주소값이 매번 다름)
         * */


        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str2 == str3: " + (str2 == str3));
        System.out.println("str3 == str4: " + (str3 == str4));

        /* 설명. equals와 hashCode 확인 */
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str1.hashCode() == str3.hashCode(): " + (str1.hashCode() == str3.hashCode()));

        /* 설명. 문자열 비교는 (==)쓰지 말고 (.equals()) 사용하자. */

        /* 설명. 문자열은 불변객체(immutable object)로 변화를 주면 항상 새로운 객체(인스턴스)를 생성한다. */
        String str = "apple";
        System.out.println(System.identityHashCode(str));
        str += ", banana";
        System.out.println(System.identityHashCode(str));
        System.out.println("fruit: " + str);
    }
}
