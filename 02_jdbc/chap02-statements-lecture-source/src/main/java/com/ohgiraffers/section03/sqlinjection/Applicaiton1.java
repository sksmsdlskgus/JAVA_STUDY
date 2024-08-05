package com.ohgiraffers.section03.sqlinjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Applicaiton1 {
    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID = '200 ";
    // 이름을 쓰라고 했는데 이상한걸 써도 출력이 된다 . 왜그럴까 ?
    // sql injection 이다 이런게
    // 근데 이걸 PreparedStatement를 사용하여 ? 를 사용한다면 이를 막을 수 있다.

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;


        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID ='" + empId + "' AND EMP_NAME ='" + empName + "'";
        System.out.println("query = " + query);

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
            } else {
                System.out.println("회원 정보가 없습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
