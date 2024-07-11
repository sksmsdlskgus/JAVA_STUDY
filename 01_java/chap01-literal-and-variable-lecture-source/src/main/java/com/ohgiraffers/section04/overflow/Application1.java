package com.ohgiraffers.section04.overflow;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 오버플로우에 대해 이해할 수 있다.
        /* 필기
         *  자료형 별 값의 최대 범위를 벗어나는 경우
         *  발생한 carry를 버림처리하고 부호 비트를 반전시켜 순환한다.
         *  */

        /* 설명. 오버플로우 */
        byte num1 = 126;

        num1 ++;        // 기존의 num1 변수에 있던 값에 1을 더해 다시 대입한다.
                        // num1 = num1 +1;
        System.out.println("num1 = " + num1);

        num1++;
        System.out.println("num1 = " + num1);

        num1++;
        System.out.println("num1 = " + num1);

        /* 설명. 언더플로우 */
        num1--;
        System.out.println("num1 = " + num1);
        num1--;
        System.out.println("num1 = " + num1);
        num1--;
        System.out.println("num1 = " + num1);

    }
}
