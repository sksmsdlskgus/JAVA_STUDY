package com.ohgiraffers.section01.exception;

public class Application {

    /* 설명. try-catch 대신 throws로 처리하면 메소드를 호출한 대상에게 예외처리를 위임한다. */
//    public static void main(String[] args) throws Exception {
public static void main(String[] args) {


        /* 수업목표. 예외에 대해 이해하고 이를 처리하기 위한 문법을 활용할 수 있다. */
        /* 필기.
        *   1. throws 를 통한 위임
        *   2. try-catch를 통한 처리
         */

        ExceptionTest et = new ExceptionTest();


        /* 설명. tru-catch를 통해 예외상황을 원하는 의도대로 처리할 수 있다. */
        try {

            /* 설명. 우리가 처리할 예외가 발생할 수 있는 적당한 범위를 try출력으로 감싼다. */
        et.checkEnoughMoney(10000, 50000);
//        et.checkEnoughMoney(50000, 10000);
            System.out.println( "이전에 문제가 없었으면 실행될 출력 구문");
    }catch (Exception e) {

            /* 설명. 우리가 원하는 방식대로 try클릭에서 발생한 예ㅚ 타입 겍체를 활용해서 처리 할 수 있다. */
            /* 설명. try클릭에서 예오가 발생하지 않으면 실행되지 않는 블럭 */
        System.out.println("뭔가 예외가 발생했나 보네?");
        System.out.println("그 예외는 " + e.getMessage() + "!!!!!");
        System.out.println("돈좀 넉넉히 들고 다니지~!");

        /* 설명.내가 원하는 시점에 프로그램을 종료할 수 있음 */
        System.exit(0); // 종료 처리

            /* 설명. 내가 원하는 시점에 프로그래을 종료할 수 있음 */
//        e.printStackTrace();  // 프로그램을 종료하는 기능은 없음

        }

//        et.checkEnoughMoney(10000, 50000); throws 할 때 잠깐 활용한 구문
    System.out.println("프러그램을 종료합니다.");
    }
}
