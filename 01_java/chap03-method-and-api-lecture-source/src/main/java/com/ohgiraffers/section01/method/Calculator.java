package com.ohgiraffers.section01.method;

public class Calculator {

    public int plusTwoNumbers(int first, int second){
        return first + second;
    }

    public  int subTwoNumgers(int first, int second){
        return first - second;

    }

    public  int multiTwoNumgers(int first, int second){
        return first * second;

    }
    public  int divideNumgersOf(int first, int second){
        return first / second;
    }

    public  int minNumgersOf(int first, int second){
        return (first > second) ? second : first;
    }

    public static int maxNumbersOf(int first, int second){
        return (first > second) ? first : second;
    }

}
