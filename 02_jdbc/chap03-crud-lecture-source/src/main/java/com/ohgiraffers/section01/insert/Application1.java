package com.ohgiraffers.section01.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;

        /* 설명.
         *   DML(insert, update, delete) 작업 시에는 반환 결과가 int가 된다.
         *   그리고, 조회와 달리 executeQuery()가 아닌 executeUpdate()를 사용하게 된다.
         * */
        int result = 0;

        String query = "INSERT INTO TBL_MENU (MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS)"
                + " VALUES (?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(query);
            // 위에 VALUES (?, ?, ?, ?) 물음표에 들어갈 순서
            pstmt.setString(1, "봉골레청국장");
            pstmt.setInt(2,5000);
            pstmt.setInt(3,4);
            pstmt.setString(4,"Y");

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(con);
        }

    }
}