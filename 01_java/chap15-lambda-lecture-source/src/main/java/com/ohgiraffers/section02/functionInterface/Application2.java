package com.ohgiraffers.section02.functionInterface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 표준 함수적 인터페이스 중 Supplier에 대해 이해하고 사용할 수 있다. */
        /* 설명. 매개변수 없고 반환 값만 있는 메소드 관련 람다식 */

        /* 설명. 추상메소드의 매개변수가 없을 경우나 2개 이상일 경우에는 소괄호(())를 생략할 수 있다.*/
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());

        BooleanSupplier booleanSupplier = () -> {
            int random = (int) (Math.random() * 2);
            return random == 0? false : true;
        };
        System.out.println("랜덤 true or false 생성기: " + booleanSupplier.getAsBoolean());
    }
}
