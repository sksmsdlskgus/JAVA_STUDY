package com.ohgiraffers.section02.template;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {
    public static Connection getConnection() {
        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(new FileInputStream("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        /* 설명. connection을 닫는 개념은 별도로 분리하고 실제로 닫는 시점을 나중에 우리가 추후 service계층에서 진행 할 예정 */

        return con; // 닫지말고 모듈화만
    }

    public static void close(Connection con) {
        try {
            if (con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
