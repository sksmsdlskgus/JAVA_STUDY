package com.ohgiraffers.section02.onetomany;

import com.ohgiraffers.section01.manytoone.Category;
import com.ohgiraffers.section01.manytoone.MenuAndCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OneToManyAssociationTests {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeAll
    public static void initFactory() {
        emf = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        em = emf.createEntityManager();
    }

    @Test
    public void 일대다_연관관계_객체_그래프_탐색을_이용한_조회_테스트() {
        int categoryCode = 4;

        CategoryAndMenu foundMenu = em.find(CategoryAndMenu.class, categoryCode);

        assertNotNull(categoryCode);
        //4의 카테고리메뉴들 전체 출력
        //--> N+1문제 발생
       // 카테고리 한개를 출력하고 싶었는데 N개가 딸려온다 ㅠㅠ..
        System.out.println("foundMenu = " + foundMenu);
    }

    @AfterEach
    public void closeManager() {
        em.close();
    }

    @AfterAll
    public static void closeFactory() {
        emf.close();
    }
}
