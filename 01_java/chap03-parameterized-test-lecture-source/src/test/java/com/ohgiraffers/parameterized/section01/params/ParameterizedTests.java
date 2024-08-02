package com.ohgiraffers.parameterized.section01.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}
