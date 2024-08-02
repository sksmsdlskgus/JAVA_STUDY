package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();

        System.out.println("con = " + con);
        Statement stmt = null;
        ResultSet rset = null;        //조회를 할 예정

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT * FROM EMPLOYEE");

            while (rset.next()) {

                /* 설명. while문 안의 rset은 한 행을 의미 */
                System.out.println(rset.getString("EMP_NAME") + " ");
                System.out.println(rset.getInt("SALARY") + "\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            /* 설명. 생성과 달리 역순으로 각 스트림을 닫는다. */
            close(rset);
            close(stmt);
            close(con);
        }


    }

}
