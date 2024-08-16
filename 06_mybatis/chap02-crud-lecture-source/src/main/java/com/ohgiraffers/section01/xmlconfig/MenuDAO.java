package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public static List<MenuDTO> selectAllMenus(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllMenus");

    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("MenuMapper.selectMenu", menuCode);
    }
}
