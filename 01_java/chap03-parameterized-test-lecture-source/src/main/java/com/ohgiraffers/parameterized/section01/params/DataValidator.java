package com.ohgiraffers.parameterized.section01.params;

import java.time.Month;

public class DataValidator {
    public static boolean isCollect(Month month){
        int monthValue = month.getValue();

        return monthValue >= 1 && monthValue <= 12;
    }

    public static int getLastDatOf(Month month){
        return month.maxLength();
    }
}
