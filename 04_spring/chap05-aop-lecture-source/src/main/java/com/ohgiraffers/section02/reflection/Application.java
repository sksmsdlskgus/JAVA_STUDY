package com.ohgiraffers.section02.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Application {
    public static void main(String[] args) {

        /* 필기.
         *   리플레션(reflection)이란?
         *   컴파일 된 자바 코드에서 필드 및 메소드의 정보를 구해오는 방법이다.
         *    스프링 프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용된다.
         *    스프링에서는 런타임 시 개발자가 등록한 빈을 애플리케이션 내부에서 다루기 위한 기술이기도 한다.
         * */

        /* 설명. 1. Class타입의 Class메타정보 추출 */
        Class class1 = Account.class;
        System.out.println("class1 = " + class1);

        Class class2 = Account.class;
        System.out.println("class2 = " + class2);

        try {

            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            Class class4 = Class.forName("[D");
            Class class5 = double[].class;
            System.out.println("class4 = " + class4);
            System.out.println("class5 = " + class5);

            Class class6 = Class.forName("[Ljava.lang.String;");
            Class class7 = String[].class;

            System.out.println("class6 = " + class6);
            System.out.println("class7 = " + class7);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 2. 필드정보 추출  */
        Field[] fields = Account.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("modifiers = " + Modifier.toString(field.getModifiers())
                    + ", type = " + field.getType()
                    + ", name = " + field.getName());
        }
    }
}
