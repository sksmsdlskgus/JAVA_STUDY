package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {
    private final MenuDAO menuDAO;

    public MenuService(){
        menuDAO = new MenuDAO();
    }

    public static List<MenuDTO> findAllMenus() {
        SqlSession sqlSession = getSqlSession();


        return null;
    }
}
