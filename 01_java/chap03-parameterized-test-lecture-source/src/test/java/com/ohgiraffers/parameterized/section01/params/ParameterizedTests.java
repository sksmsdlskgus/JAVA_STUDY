package com.ohgiraffers.parameterized.section01.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.annotation.*;
import java.time.Month;
import java.util.stream.Stream;

public class ParameterizedTests {

    /* 목차. 1. @ ValueSource를 이용한 parameter value 목록 지정 */
    @DisplayName("홀수 짝수 판별 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, -1, 15, 123})
    void testIdOdd(int number) {

        // given (ValueSoure 자체가 given 이다.)
        // when
        boolean result = NumberValidator.isOdd(number);

        // then
        Assertions.assertTrue(result);

    }

    @DisplayName("null값 테스트")
    @ParameterizedTest
    @NullSource
    void testIsNull(String input) {

        // when
        boolean result = StringValidator.isNull(input);

        // then
        Assertions.assertTrue(result);

    }

    @DisplayName("empty값 테스트")
    @ParameterizedTest
    @EmptySource
    void testIsEmpty(String input) {

        // when
        boolean result = StringValidator.isEmpty(input);

        // then
        Assertions.assertTrue(result);

    }

    @DisplayName("blank값 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void testIsBlank(String input) {

        // when
        boolean result = StringValidator.isBlank(input);

        // then
        Assertions.assertTrue(result);

    }

    @DisplayName("Month에 정의 된 타입들이 1~12월 사이의 범위인지 테스트")
    @ParameterizedTest
    @EnumSource(Month.class)
    void testIsMonthValueCollect(Month month) {
        boolean result = DataValidator.isCollect(month);
        Assertions.assertTrue(result);

    }

    @DisplayName("4월, 6월, 9월, 11월이 30일인지 확인")
    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void testHasThirtyDaysLong(Month month) {

        int verifyValue = 30;

        int actual = DataValidator.getLastDatOf(month);
        Assertions.assertEquals(verifyValue,actual);

    }

    @DisplayName("2월, 4월, 6월, 9월, 11월을 제외한 달이 31일인지 확인")
    @ParameterizedTest
    @EnumSource(value = Month.class,
            names = {"FEBRUARY","APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"},
            mode = EnumSource.Mode.EXCLUDE
    )
    void testHasThirtyOneDaysLong(Month month) {

        int verifyValue = 31;

        int actual = DataValidator.getLastDatOf(month);
        Assertions.assertEquals(verifyValue,actual);

    }


    @DisplayName("영문자를 대문자로 변경하는지 확인")
    @ParameterizedTest
    @CsvSource(    // String 형태로 두개의 매개변수를 각각 넘겨주고 싶다면
            value = {"test:TEST", "tEst: TEST", "JavaScript: JAVASCRIPT"},
            delimiter = ':'
    )
    void testToUpperCase(String input, String verifyValue) {
        System.out.println("input = " + input);
        System.out.println("verifyValue = " + verifyValue);

        String actual = input.toUpperCase();
        Assertions.assertEquals(verifyValue,actual);
    }

    @DisplayName("CSV 파일을 읽은 테스트 데이터를 테스트에 활용하는지 확인")
    @ParameterizedTest

    /* 설명. numLinesToSkip은 파일을 읽어들일 때 위에서 부터 무시할 라인 수를 입력 */
    @CsvFileSource(resources = "/parameter-test-data.csv", numLinesToSkip = 2)
    void testToUpperCaseWithCSVFileData(String input, String verifyValue) {
        System.out.println("input = " + input);
        System.out.println("verifyValue = " + verifyValue);

        String actual = input.toUpperCase();
        Assertions.assertEquals(verifyValue, actual);
    }

    public static Stream<Arguments> providerStringSource(){
        return Stream.of(
                Arguments.of("hello world", "HELLO WORLD"),
                Arguments.of("JavaScript", "JAVASCRIPT"),
                Arguments.of("tEst", "TEST")
        );
    }


    @DisplayName("메소드 소스를 활용한 대문자 변환 테스트")
    @ParameterizedTest
    @MethodSource("providerStringSource")
    void testToUpperCaseWithMethodSource(String input, String verifyValue) {
        String actual = input.toUpperCase();

        Assertions.assertEquals(verifyValue, actual);
    }

    @DisplayName("두 수를 더한 결과를 정상적으로 반환하는지 테스트")
    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}(이)가 맞는지 확인")
    @ArgumentsSource(SumTwoNumbersArgumentsProvider.class)
    void testSumTwoNumbers(int num1, int num2, int verifyValue) {
        int actual = Calculator.sumTwoNumbers(num1, num2);

        Assertions.assertEquals(verifyValue, actual);
    }

}
