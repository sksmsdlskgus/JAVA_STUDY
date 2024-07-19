package com.ohgiraffers.section01.section02.userexception;

import com.ohgiraffers.section01.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section01.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section01.section02.userexception.exception.PriceNegativeException;

public class Application1 {
    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();
        try {
            et.checkEnoughMoney(30000, 40000);
        } catch (PriceNegativeException e) {
            System.out.println(e.getMessage());
        } catch (MoneyNegativeException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
}