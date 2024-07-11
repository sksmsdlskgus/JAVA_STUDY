package com.ohgiraffers.section03.math;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. math 클래스에서 제공하는 static 메소드를 호출할 수 있다.  */

        /* 설명. 참고로, java.lang 패키지 소속은 import 또는 풀 믈래스명을 쓸 필요가 없다. */

        /* 설명.  1. 절대값 출력 */
        System.out.println("-32.1의 절대값: " + java.lang.Math.abs(-32.1) );

        /* 설명. 2. 최대값, 최소값 출력 */
        System.out.println("10과 20 중 더 작은 것은: " + Math.min(10,20));
        System.out.println("20과 30 중 더 큰 것은: " + Math.max(20,30));

        /* 설명. 3. 난수 생성 */
        System.out.println("난수 생성 : " + Math.random());
    }
}
