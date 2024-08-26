package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.aggregate.entity.Category;
import com.ohgiraffers.springdatajpa.menu.aggregate.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/* 설명.
 *  Service 계층
 *  1. 비즈니스 로직
 *  2. 트랜잭션 처리
 *  3. DTO <-> Entity(modelmapper lib 활용)
 * */
@Service
public class MenuService {

    /* 설명. bean 등록 하고 올 것 */
    private final ModelMapper mapper;
    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MenuService(ModelMapper mapper, MenuRepository menuRepository, CategoryRepository categoryRepository) {
        this.mapper = mapper;
        this.menuRepository = menuRepository;
        this.categoryRepository = categoryRepository;
    }

    /* 설명. 1. findById 예제 */
    public MenuDTO findMenuByCode(int menuCode) {
        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);

        return mapper.map(menu, MenuDTO.class);
    }

    /* 설명. 2. findAll(페이징 처리 전) */
    public List<MenuDTO> findMenuList() {

        List<Menu> menus = menuRepository.findAll(Sort.by("menuCode").descending());

        return menus.stream().map(menu -> mapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
    }

    /* 설명. 3. findAll(페이징 처리 후, Pageable 활용) */
    public Page<MenuDTO> findMenuList(Pageable pageable) {

        /* 설명.
         *  1. 넘어온 Pageble에 담긴 페이지 번호를 인덱스 개념으로 바꿔서 인지 시킴
         *  2. 한 페이지에 뿌려질 데이터 크기
         *  3. 정렬 기준
         * */
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending());

        Page<Menu> menuList = menuRepository.findAll(pageable);

        return menuList.map(menu -> mapper.map(menu, MenuDTO.class));
    }

    /* 설명. 4. Query Method 활용 */
    public List<MenuDTO> findMenuPrice(int menuPrice) {

        /* 설명. 전달받은 가격을 초과하는 메뉴들을 조회하는 쿼리메소드(Spring Data Jpa) */
        List<Menu> menus = menuRepository.findByMenuPriceGreaterThan(menuPrice);

        return menus.stream().map(menu -> mapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
    }

    /* 설명. 5. JPQL 또는 Native Query */
    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList
                .stream()
                .map(category -> mapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    /* 설명. Spring Data JPA 로 DML작업하기(insert, update,delete) */
    @Transactional
    public void registMenu(MenuDTO newMenu) {

        /* 설명. MenuDTO에서 Menu로 바꿔서 넘기고 modelmapper 활용 시에는 엔티티에 setter가 필요하다. */
        menuRepository.save(mapper.map(newMenu, Menu.class));
    }

    /* 설명. 7. 수정하기 - 엔티티 영속 상태로 바꿔 (find 활용) 해당 객체 값 변경 */
    @Transactional
    public void modifyMenu(MenuDTO modifyMenu) {
        Menu foundMenu = menuRepository.findById(modifyMenu.getMenuCode()).orElseThrow(IllegalArgumentException::new);
        foundMenu.setMenuName(modifyMenu.getMenuName());

    }


    /* 설명. 8. 삭제하기 -delete */
    @Transactional
    public void deleteMenu(int menuCode) {
        menuRepository.deleteById(menuCode);
    }
}










