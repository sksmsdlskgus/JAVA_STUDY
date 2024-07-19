package com.ohgiraffers.section05.calender;

import java.sql.SQLData;
import java.text.SimpleDateFormat;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. java.util.Date 클래스 사용법을 이해하고 사용할 수 있다. */
        java.util.Date today = new java.util.Date();        // 시스템의 현재 시간을 가진 객체 생성
        System.out.println("today = " + today);

        System.out.println("long 타입 시간: " + today.getTime());   // KST로 1970년 1월 1일 오전 9시 이후 흐름 milliseconds
        System.out.println("long 타입 시간을 활용한 Date:" + new java.util.Date(0L)) ;
        System.out.println("현재 시간을 활용한 Date: " + new java.util.Date(today.getTime()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss E요일");
        String todayFormat = sdf.format(today);
        System.out.println("todayFormat = " + todayFormat);

        /* 설명. java.util.Date -> java.sql.Date  */
        java.util.Date today2 = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(today.getTime());           //sql.Date형의 생성자 활용

        /* 설명. util.Date를 sql.Date로 다운캐스팅을 하기 위해선 실제 객체가 sql.Date형이어야 한다. */
//        java.sql.Date sqlDate2 = (java.sql.Date)today2;
//        System.out.println(sqlDate2);

        /* 설명. java.sql.Date -> java.util.Date  */
        java.util.Date utilDate = sqlDate;      // 다형성 적용
    }
}
