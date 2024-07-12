package com.ohgiraffers.section03.branching;

public class A_break {
    public void testSimpleBreakStatement(){
        int sum = 0;
        int i =1;
        while(true){
            sum += i;
            System.out.println("sum = " + sum);

            if(i == 10){        // 반복문 안에서 조건문 사용가능
                break;             // 가장 가까운 반복문을 빠져나간다.
            }
            i++;
        }
    }
}
