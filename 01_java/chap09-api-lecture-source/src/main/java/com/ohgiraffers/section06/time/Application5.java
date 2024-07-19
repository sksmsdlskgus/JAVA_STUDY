package com.ohgiraffers.section06.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Application5 {
    public static void main(String[] args) {

        /* 수업목표. tinme 패티지의 클래스들에 포매팅을 적용하여 출력할 수 있다. */
         String timeNow = "14:05:10";
         String dateNow = "2022-10-12";

        LocalTime localTime = LocalTime.parse(timeNow);
        LocalDate localDate = LocalDate.parse(dateNow);
        LocalDateTime localDateTime = LocalDateTime.parse(dateNow + "T" + timeNow);

        System.out.println("LocalTime: " + localTime);
        System.out.println("LocalDate: " + localDate);
        System.out.println("LocalDateTime: " + localDateTime);

        /* 설명. 패턴을 인식해 줘야할 시 */
        String timeNow2 = "14-05-10";
        String dateNow2 = "221005";


        LocalTime localTime2 = LocalTime.parse(timeNow2, DateTimeFormatter.ofPattern("HH-mm-ss"));
        LocalTime localDate2 = LocalTime.parse(timeNow2, DateTimeFormatter.ofPattern("yyMMdd"));

        System.out.println("LocalTime2: " + localTime2);
        System.out.println("LocalDate2: " + localDate2);

        /* 설명.  time 패키지가 인식한 날짜 및 시간을 워하는 문자열로 반환하기*/
        String dateFormat = localDate2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String timeFormat = localTime2.format(DateTimeFormatter.ofPattern("HH mm"));
        System.out.println("dateFormat: " + dateFormat);
        System.out.println("timeFormat: " + timeFormat);
    }
}
