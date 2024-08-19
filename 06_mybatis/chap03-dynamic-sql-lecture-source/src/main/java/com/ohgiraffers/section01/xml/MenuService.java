package com.ohgiraffers.section01.xml;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xml.Template.getSqlSession;

public class MenuService {
    public void findMenuByPrice(int price) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.selectMenuByPrice(price);
        menus.forEach(System.out::println);

        sqlSession.close();

    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();

        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.searchMenu(searchCriteria);
        menus.forEach(System.out::println);

        sqlSession.close();

    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();

        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.searchMenuBySupCategory(searchCriteria);

        if (menus != null && menus.size() > 0) {
            menus.forEach(System.out::println);
        } else {
            System.out.println("DB와의 연동 실패 또는 검색 결과 없음");
        }

        sqlSession.close();

    }

    public void searchMenuByRandomMenuCode(List<Integer> randomList) {
        SqlSession sqlSession = getSqlSession();

        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.searchMenuByRandomMenuCode(randomList);

        if (menus != null && menus.size() > 0) {
            menus.forEach(System.out::println);
        } else {
            System.out.println("DB와의 연동 실패 또는 검색 결과 없음");
        }

        sqlSession.close();

    }

    public void searchMenuByCodeDrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();

        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.searchMenuByCodeDrSearchAll(searchCriteria);

        if (menus != null && menus.size() > 0) {
            menus.forEach(System.out::println);
        } else {
            System.out.println("DB와의 연동 실패 또는 검색 결과 없음");
        }

        sqlSession.close();
    }
}
