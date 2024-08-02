package com.ohgiraffers.section02.template;

import java.sql.Connection;


/* 설명. import static은 메소드명까지 작성하며  static메소드를 '클래스명'을 생략하고 호출 할 수 있다. */
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;
import static com.ohgiraffers.section02.template.JDBCTemplate.close;

public class Application {
    public static void main(String[] args) {
        Connection con = getConnection();
        System.out.println("con = " + con);

        /* 설명. 하나의 트랜젝션 단위에 대한 비지니스 로직 설명 */
        close(con);
    }
}
