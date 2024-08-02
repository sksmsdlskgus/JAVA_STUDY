package com.ohgiraffers.section01.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(new FileInputStream("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
//            try { 아래에 따로 메소드를 빼주면서 가독성을 높여줌
//                if (con != null) con.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            close(con);
        }
    }

    private static void close(Connection con) {
        try {
            if (con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
