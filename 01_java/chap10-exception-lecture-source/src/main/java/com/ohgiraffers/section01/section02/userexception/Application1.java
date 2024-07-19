package com.ohgiraffers.section01.section02.userexception;

import com.ohgiraffers.section01.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section01.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section01.section02.userexception.exception.PriceNegativeException;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 사용자 정의형 예외클래스 정의 후 발생한 사용자 예외들을 처리할 수 있다. */
        ExceptionTest et = new ExceptionTest();
        try {
            et.checkEnoughMoney(30000, 40000);
//            et.checkEnoughMoney(-30000, 40000);
//            et.checkEnoughMoney(30000, -40000);
            et.checkEnoughMoney(100000, 10);
        } catch (PriceNegativeException e) {
            System.out.println(e.getMessage());
        } catch (MoneyNegativeException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("어떤 예외든 커몬");
            System.out.println("어떤 예외든 메시지는: " + e.getMessage());
        }
    }
}