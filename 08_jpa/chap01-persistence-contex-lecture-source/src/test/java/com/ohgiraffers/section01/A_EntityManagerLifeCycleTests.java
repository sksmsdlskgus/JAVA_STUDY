package com.ohgiraffers.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class A_EntityManagerLifeCycleTests {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeAll
    public static void initFactory(){
        emf = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager(){
        em = emf.createEntityManager();
    }

    @Test
    public void 엔티티_매니저_팩토리와_엔티티_매니저_생명주기_확인1(){
        System.out.println("factory의 hashCode: " + emf.hashCode());
        System.out.println("manager의 hashCode: " + em.hashCode());

    }

    @Test
    public void 엔티티_매니저_팩토리와_엔티티_매니저_생명주기_확인2(){
        System.out.println("factory의 hashCode2: " + emf.hashCode());
        System.out.println("manager의 hashCode2: " + em.hashCode());

    }

    @AfterEach
    public void closeManager(){
        em.close();
    }

    @AfterAll
    public static void closeFactory(){
        em.close();
    }




}
