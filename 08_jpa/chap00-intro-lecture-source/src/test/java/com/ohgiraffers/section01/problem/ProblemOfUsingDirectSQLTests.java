package com.ohgiraffers.section01.problem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ProblemOfUsingDirectSQLTests {
    private Connection con;

    @BeforeEach
    void setConnection() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
        String user = "swcamp";
        String password = "swcamp";

        con = DriverManager.getConnection(url,user,password);
        con.setAutoCommit(false);
    }

    /* 필기.
    *    JDBC API를 이용해 직접 SQL을 다룰 떄 발생할 수 있는 문제점
    *   1. 데이터 변환, SQL작성, JDBC API 코드 등을 중복 작성(개발시간 증가, 유지보수 저하)
    *   2. SQL에 의존하여 개발
    *   3. 패러다임 불일치(상속, 연관관계, 객체 그래프 탐색, 방향성)
    *   4. 동일성 보장 문제
    * */

    @AfterEach
    void closeConnection() throws SQLException {
        con.rollback();
        con.close();
    }


}