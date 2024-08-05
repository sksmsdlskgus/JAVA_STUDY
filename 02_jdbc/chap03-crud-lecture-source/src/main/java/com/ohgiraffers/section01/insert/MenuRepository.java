package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuRepository {
    public int insertMenu(Connection con, Menu registMenu) {
        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties(); //prop에 mapper의 키와 벨류의 한쌍이 담긴다.

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section01/insert/mapper/menu-mapper.xml"));
            String query = prop.getProperty("insertMenu"); // 키값과 동일한 이름으로 넣어줘야 키값이 넘어온다. 물론 불완전한 ? 형태로 넘어올것임
//            System.out.println("query = " + query);
//            System.out.println("사용자가 입력한 추가할 메뉴 정보: " + registMenu); //입력값이 받아지는지 확인차

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, registMenu.getMenuName());
            pstmt.setInt(2,registMenu.getMenuPrice());
            pstmt.setInt(3,registMenu.getCategoryCode());
            pstmt.setString(4,registMenu.getOrderableStatus());

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }

        return result;
    }
}
