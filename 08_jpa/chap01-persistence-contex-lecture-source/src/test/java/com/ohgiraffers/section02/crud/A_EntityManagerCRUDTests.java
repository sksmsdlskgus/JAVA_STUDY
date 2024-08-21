package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class A_EntityManagerCRUDTests {
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
    public void 메뉴코드로_메뉴_조회_테스트() {
        //given
        int menuCode = 3;

        //when
        Menu foundMenu = em.find(Menu.class, menuCode);

        //then
        Assertions.assertNotNull(foundMenu);
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode());
        System.out.println("foundMenu = " + foundMenu);

    }

    @Test
    public void 새로운_메뉴_추가_테스트() {

        //given
        Menu menu = new Menu();
        menu.setMenuName("꿀발린추하다");
        menu.setMenuPrice(7000);
        menu.setCategoryCode(4);
        menu.setOrderableStatus("Y");

        //when
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.persist(menu);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

        //then
        Assertions.assertTrue(em.contains(menu));   //영속성 컨텍스트에 menu가 존재하는지 확인


    }

    @Test
    public void 메뉴_추가하기_테스트() {

        //given
        Menu menu = em.find(Menu.class, 2);

        String menuInsert = "갈치뭐라냐";

        //when
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            menu.setMenuName(menuInsert);
            menu.setMenuPrice(2000);
            menu.setCategoryCode(1);
            menu.setOrderableStatus("Y");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

        //then
        Assertions.assertTrue(em.contains(menu));

    }

    @Test
    public void 메뉴_이름_수정_테스트() {
        //given
        Menu menu = em.find(Menu.class, 2);
        System.out.println("menu = " + menu);

        String menuNAmeToChange = "갈치보단고등어보단잉어";

        //when
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            menu.setMenuName(menuNAmeToChange);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

        //then
        Assertions.assertEquals(menuNAmeToChange, em.find(Menu.class, 2).getMenuName());

    }

    @Test
    public void 메뉴_삭제하기_테스트() {

        //given
        Menu menuToRemove = em.find(Menu.class, 44);

        //when
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.remove(menuToRemove);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

        //then
        Menu removeMenu = em.find(Menu.class, 44);
        Assertions.assertEquals(null, removeMenu);
    }



    @AfterEach
    public void closeManager() {
        em.close();
    }

    @AfterAll
    public static void closeFactory() {
        em.close();
    }

}
