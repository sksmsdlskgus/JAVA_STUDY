package com.ohgiraffers.assertions.section01.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* 수업목표. junit5에서 제공하는 Assertions에 있는 메소드에 대해 이해하고 활용할 수 있다. */

class JupiterAssertionsTests {

    /* 목차. 1. assertEquals */
    /* 필기. assertEquals(expected, actual) 메소드는 실제값과 일치 여부를 동일성으로 판단한다. */
    @Test
    public void testAssertEquals() {

        /* 설명. 1. given */
        int firstNum = 10;
        int secondNum = 20;
        int expected = 31;

        /* 설명. 2. when */
        Calculator calculator = new Calculator();
        int result = calculator.plusTwoNumbers(firstNum, secondNum);

        /* 설명. 3. then */
//        Assertions.assertEquals(expected, result);
//        Assertions.assertEquals(expected, result, 1);       // 오차범위에 해당하는 매개변수도 제공
        Assertions.assertNotEquals(expected, result);
    }

    /* 목차. 2. assertNull */
    @Test
    @DisplayName("null인지 테스트")
    void testAssertNull() {
        String str;
        str = null;
        Assertions.assertNull(str);
    }

    /* 목차. 3. assertNotNull */
    @Test
    @DisplayName("null인 아닌지 테스트")
    void testAssertNotNull() {
        String str;
        str = "java";
        Assertions.assertNotNull(str);
    }

    /* 목차. 4. assertAll */
    @Test
    @DisplayName("동시에 여러 가지 값에 대한 검증을 수행하는 경우 테스트")
    void testAssertAll() {

        String firstName = "길동";
        String lastName = "홍";

        Person person = new Person(firstName, lastName);

        Assertions.assertAll(
                "그룹화된 테스트의 이름(테스트 실패 시 보여짐)",
                () -> Assertions.assertEquals(firstName, person.getFirstName(), () -> "firstName이 잘못됨"),
                () -> Assertions.assertEquals(lastName, person.getLastName(), () -> "lastName이 잘못됨")
        );
    }

    /* 목차. 5. assertThrows/assertInstanceOf/assertEquals */
    @Test
    @DisplayName("void 메소드의 경우 exception이 발생하는지 테스트")
    void testAssertThrows() {
        int firstNum = 10;
        int secondNum = 0;
        String expectedErrorMessage = "0으로 나눌 수 없습니다.";

        NumberValidation validator = new NumberValidation();
        Exception excpetion = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.checkDivedableNumbers(firstNum, secondNum)
        );

    }
}