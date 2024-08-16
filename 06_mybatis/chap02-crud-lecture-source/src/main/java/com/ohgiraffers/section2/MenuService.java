package com.ohgiraffers.section2;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section2.Template.getSqlSession;


public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDTO> findAllMenus() {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        ;// 의존성 주입 방식 !!!!!!!!
        List<MenuDTO> menuList = menuMapper.selectAllMenus();
        sqlSession.close();

        return menuList;
    }

    public MenuDTO findMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menu = menuMapper.selectMenu(menuCode);

        sqlSession.close();

        return menu;
    }

    public boolean regisMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();


        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean updateMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean remove(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(menuCode);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}