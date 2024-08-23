package com.ohgiraffers.section01.simple;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleJPQLTests {

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
    public void TypeQuery를_이용한_단일행_단일열_조회_테스트() {
        String jpql = "SELECT menuName FROM Menu WHERE menuCode = 7";
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        // 단일열 조회시 타입 지정 String으로 전환 후 조회 해줌

        String resultMenuName = query.getSingleResult(); // getSingleResult()을 이용해 한행을 뽑을 수 있고, 자바로 담기

        System.out.println("resultMenuName = " + resultMenuName);

        assertEquals("웅룰룰까궁", resultMenuName);

    }

    @Test
    public void Query를_이용한_단일행_단일열_조회_테스트() {
        String jpql = "SELECT menuName FROM Menu WHERE menuCode = 7";
        Query query = em.createQuery(jpql);
        //Query 는 제네릭 개념이 없으므로 타입 지정 못함

        Object resultMenuName = query.getSingleResult();
        // getSingleResult()을 이용해 한행을 뽑을 수 있고, 자바로 담기
        // 타입을 지정할 수 없으니 Object로 담아 다형성으로 접근

        assertTrue(resultMenuName instanceof String);

        assertEquals("웅룰룰까궁", resultMenuName);

//        //단일행 부분열 조회일 경우(프로젝션 활용(그 중에 Object[]로 받는 방식))
//        String jpql = "SELECT menuName,menuPrice FROM Menu WHERE menuCode = 7";
//        Query query = em.createQuery(jpql);
//
//        List<Object[]> resultColumns = query.getResultList();
//        // 단일행임에도 List<Object[]>로 반환받아 다루게 된다.
//
//        Arrays.stream(resultColumns.get(0)).forEach(System.out::println);
//        assertTrue(resultColumns.get(0)[0] instanceof String);
//        assertTrue(resultColumns.get(0)[1] instanceof String);


    }

    @Test
    public void TypeQuery를_이용한_다중행_다중열_조회_테스트() {

        /* 설명. jpql에서는 entity의 별칭을 적으면 모든 속성(컬럼)을 조회하는것이다. */
        String jpql = "SELECT m FROM Menu as m";
        TypedQuery<Menu> query = em.createQuery(jpql, Menu.class);

        List<Menu> foundMenuList = query.getResultList();

        assertTrue(!foundMenuList.isEmpty());
        foundMenuList.forEach(System.out::println);

    }

    @Test
    public void distinct를_이용한_중복제거_여러_행_조회_테스트() {

        /* 설명. 메뉴로 존재하는 카테고리의 종류(중복제거) 조회 */
        String jpql = "SELECT DISTINCT m.categoryCode FROM Menu m";
        TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
        List<Integer> categoryCodeList = query.getResultList();

        assertTrue(!categoryCodeList.isEmpty());
        categoryCodeList.forEach(System.out::println);

    }

    @Test
    public void in_연산자를_활용한_조회_테스트() {

        /* 설명. 카테고리 코드가 6번 또는 10번인 메뉴를 조회 */
        String jpql = "SELECT m FROM Menu m WHERE m.categoryCode IN (6,10)";
//        TypedQuery<Menu> query = em.createQuery(jpql, Menu.class);
//        List<Menu> foundMenuList = query.getResultList();

        List<Menu> foundMenuList = em.createQuery(jpql, Menu.class).getResultList();

        assertTrue(!foundMenuList.isEmpty());
        foundMenuList.forEach(System.out::println);

    }

    @Test
    public void like_연산자를_활용한_조회_테스트() {

        /* 설명. 카테고리 코드가 6번 또는 10번인 메뉴를 조회 */
        String jpql = "SELECT m FROM Menu m WHERE m.categoryCode LIKE %밥%";

        List<Menu> foundMenuList = em.createQuery(jpql, Menu.class).getResultList();

        assertTrue(!foundMenuList.isEmpty());
        foundMenuList.forEach(System.out::println);

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
