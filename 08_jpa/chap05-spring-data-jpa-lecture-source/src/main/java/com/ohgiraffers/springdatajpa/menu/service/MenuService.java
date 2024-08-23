package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.aggregate.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/* 설명.
*   Service 계층
*   1. 비지니스 로직
*   2. 트랜잭션 처리
*   3. DTO <-> Entity(modelmapper lib 활용) */
@Service
public class MenuService {

    /* 설명. bean 등록 하고 올 것 */
    private final ModelMapper mapper;
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(ModelMapper mapper, MenuRepository menuRepository, MenuRepository menuRepository1) {
        this.mapper = mapper;
        this.menuRepository = menuRepository;
    }


    /* 설명. 1. findById 예제 */
    public MenuDTO findMenuByCode(int menuCode) {
        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        //JpaRepository에서 물려받은 findById()를 이용해 optional 제네릭에서 제공하는 예외처리까지 받기

        return mapper.map(menu, MenuDTO.class); //menu를 MenuDTO.class로 바꿔줘 (엔티티에서 디티오로 변환)
    }

    /* 설명. 2. findAll (페이징 처리 전)  */
    public List<MenuDTO> findMenuList() { // 페이징 처리 전
        List<Menu> menus = menuRepository.findAll(Sort.by("menuCode").descending());

        return menus.stream().map(menu -> mapper.map(menu,MenuDTO.class)).collect(Collectors.toList());
        // List<Menu>에서 Menu들을 꺼내어 MenuDTO로 바꾸고(Stream)
    }

    /* 설명. 3. findAll (페이징 처리 후, Pageable 활용)  */
    public Page<MenuDTO> findMenuList(Pageable pageable) { // 페이징 처리 후
        /* 설명.
        *   1. 넘어온 Pageble에 담긴 페이지 번호를 인덱스 개념으로 바꿔서 인지 시킴
        *   2. 한 페이지에 뿌려질 데이터 크기
        *   3.  정렬 기준 */

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
}
