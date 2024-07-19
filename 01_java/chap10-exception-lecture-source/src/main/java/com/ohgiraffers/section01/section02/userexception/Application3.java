package com.ohgiraffers.section01.section02.userexception;

import com.ohgiraffers.section01.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section01.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section01.section02.userexception.exception.PriceNegativeException;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. multi-catch구문을 이해하고 활용할 수 있다. */
        ExceptionTest2 et = new ExceptionTest2();
        try {
            et.checkEnoughMoney(20000, 10);
        } catch (PriceNegativeException | MoneyNegativeException e) {
            System.out.println("두 개의 예외 처리 방식");
        } catch (NotEnoughMoneyException e) {
            System.out.println("한 개의 예외 처리 방식");
            e.printStackTrace();
        } finally {
            System.out.println("반드시 실행되어야 하는 구문");
        }

        System.out.println("프로그램 종료");
    }
}