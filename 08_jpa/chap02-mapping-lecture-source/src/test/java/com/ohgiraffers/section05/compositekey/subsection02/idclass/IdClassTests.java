package com.ohgiraffers.section05.compositekey.subsection02.idclass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdClassTests {

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
    public void 아이디_클래스_사용한_복합키_테이블_매핑_테스트() {

        Member member = new Member();
        member.setMemberNo(1);
        member.setMemberId("user01");
        member.setPhone("010-3333-2222");
        member.setAddress("서울시 종로구");

        // when
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(member);

        // then
        tx.commit();

        Member foundMember = em.find(Member.class, new MemberPk(1,"user01"));
        assertEquals(member.getMemberNo(), foundMember.getMemberNo());

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
