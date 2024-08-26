package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.aggregate.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /* 설명. 1. JPQL을 활용한 카테고리 조회 */
//    @Query(value="SELECT c FROM Category c ORDER BY c.categoryCode ASC")

    /* 설명. 2. Native Query를 활용한 카테고리 조회 */
    @Query(value="SELECT C.CATEGORY_CODE, C.CATEGORY_NAME, C.REF_CATEGORY_CODE "
            + "FROM TBL_CATEGORY C ORDER BY C.CATEGORY_CODE ASC", nativeQuery = true)
    List<Category> findAllCategory();
}