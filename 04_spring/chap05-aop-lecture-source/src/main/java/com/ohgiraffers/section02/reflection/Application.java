package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {

        /* 필기.
         *   리플렉션(reflection)이란?
         *   컴파일 된 자바 코드에서 필드 및 메소드의 정보를 구해오는 방법이다.
         *    스프링 프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용된다.
         *    스프링에서는 런타임 시 개발자가 등록한 빈을 애플리케이션 내부에서 다루기 위한 기술이기도 한다.
         *
         *  필기.
         *   reflection은 강력한 도구이지만 무분멸하게 사용해서는 안된다.
         *   1. 오버헤드 발생: 성능 저하를 발생할 수 있기 때문에 민감한 애플리케이션에는 사용하지 않는다.
         *   2. 캡슐화 저해: private를 설정한 필드 또는 메소드에 접근 가능하기 때문에 코드 기능이 저하되며
         *                해석이 어려ㅕ워 여러가지 문제를 야기할 수 있다.
         *
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

        /* 설명. 3. 생성자 정보 추출 */
        Constructor[] constructors = Account.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("name: " + constructor.getName());

            Class[] params = constructor.getParameterTypes();
            for (Class param : params) {
                System.out.println("paramType: " + param.getTypeName());
            }
        }

        try {

            Account acc = (Account) constructors[0].newInstance("20", "1012-3203023-3333", "1234", 1099);
            System.out.println(acc.getBalance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 4.메소드 정보 추출 */
        Method[] methods = Account.class.getMethods();
        Method getBalancethod = null;
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " "
                    + method.getReturnType().getSimpleName()
                    + " " + method.getName());
            if ("getBalance".equals(method.getName())) {
                getBalancethod = method;
            }
        }
        try {

            System.out.println(getBalancethod.invoke(((Account) constructors[2].newInstance())));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
