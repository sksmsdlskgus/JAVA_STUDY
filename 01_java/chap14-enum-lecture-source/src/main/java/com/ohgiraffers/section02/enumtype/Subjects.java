package com.ohgiraffers.section02.enumtype;

public enum Subjects {
    JAVA,              //0
    MARIADB,           //1
    JDBC,              //2
    HTML,              //3
    CSS,               //4
    JAVASCRIPT;        //5

    Subjects(){
        System.out.println("기본생성자 호출됨.");
    }


    @Override
    public String toString() {
        return "@@@@" + this.name() + "@@@@";
    }
}
