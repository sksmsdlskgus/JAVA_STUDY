package com.ohgiraffers.section01.xml;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuService {
    public void findMenuByPrice(int price) {
        SqlSession sqlSession = Template.getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.selectMenuByPrice(price);
        menus.forEach(System.out::println);

    }
}
