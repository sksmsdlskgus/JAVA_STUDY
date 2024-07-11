package com.ohgiraffers.section02.assigment;

public class Application1 {

    /* 수업목표. 복합대입 연산자를 이해하고 활용할 수 있다. */
    /*  필기.
     *  대입연산자와 산술 복합 대입 연산자
     *   '=', '+=', '-=','*=','/=','%='
     */

    public static void main(String[] args) {
        int num = 12;
        System.out.println("num = " + num);

        num = num + 3;              // 메모리를 두번 찾아가는 꼴이 됨 -> 복합연산자 사용 해결
        System.out.println("num = " + num);

        num += 3;
        System.out.println("num = " + num);

        num -=5;
        System.out.println("num = " + num);

        num *= 2;
        System.out.println("num = " + num);

        num /= 2;
        System.out.println("num = " + num);

        num %= 10;
        System.out.println("num = " + num);

        /* 주의 ! */
        num =- 5;        //equal(=) 기호 오른쪽은 복합 대입 연산자가 아니다.
        System.out.println("num = " + num);

    }
}
