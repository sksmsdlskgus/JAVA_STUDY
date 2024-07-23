package com.ohgiraffers.section01.list.run;

import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표. Stack에 대해 이해하고 사용할 수 있다. */
        /* 필기. 
        *   Stack이란?
        *    후입선출(LIFO) 또는 선입후출(FILO)의 자료 구조로 push() pop(), peek()등의 메소드를
        *    활용하여 자료를 처리 할 수 있다.*/

        Stack<Integer> IntegerStack = new Stack<>();

        /* 설명. Stack 인스턴스 생성 후 데이터 추가 */
        IntegerStack.push(1);
        IntegerStack.push(2);
        IntegerStack.push(3);
        IntegerStack.push(4);
        IntegerStack.push(5);

        System.out.println(IntegerStack);

        System.out.println("peek(): " + IntegerStack.peek());
        System.out.println(IntegerStack);

        System.out.println("search(): " + IntegerStack.search(1));
        System.out.println(IntegerStack);

        System.out.println("pop(): " + IntegerStack.pop());
        System.out.println("pop(): " + IntegerStack.pop());
        System.out.println("pop(): " + IntegerStack.pop());
        System.out.println("pop(): " + IntegerStack.pop());
        System.out.println(IntegerStack);

    }

}
