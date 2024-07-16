package com.ohgiraffers.section05.parameter;

import java.util.Arrays;

public class ParameterTest {
    public void testPrimitiveTypeParameter(int num) {
        num = 10;
        System.out.println("매개변수로 전달받은 값: " + num);
    }

    public void testPrimitiveTypeArrayParameter(int[] iArr) {
        iArr[0] = 100;
        System.out.println("매개변수로 전달받은 값: " + Arrays.toString(iArr));
        
    }

    public void testClassTypeParameter(Rectangle rectangle) {
        rectangle.calArea();
        rectangle.calRound();
        
    }

    public void testVariableLengthArrayParameter(String...str) {
        // 재료를 받을 준비는 되어있는데 안 던저줘도 ㄱㅊ 0개 이상의미

        System.out.println("Arrays.toString(str) = " + Arrays.toString(str));
        
    }
}
