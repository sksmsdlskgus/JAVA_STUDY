package com.ohgiraffers.section03.branching;

public class Application {
    public static void main(String[] args) {
        A_break aClass = new A_break();
        aClass.testSimpleBreakStatement();

        B_continue bContinue = new B_continue();
        bContinue.testSimpleContinueStatement();
    }
}
