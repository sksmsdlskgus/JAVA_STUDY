package com.ohgiraffers.section01.xml;

import java.util.List;

public interface MenuMapper {
    List<MenuDTO> selectMenuByPrice(int price);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByRandomMenuCode(List<Integer> randomList);

    List<MenuDTO> searchMenuByCodeDrSearchAll(SearchCriteria searchCriteria);
}
