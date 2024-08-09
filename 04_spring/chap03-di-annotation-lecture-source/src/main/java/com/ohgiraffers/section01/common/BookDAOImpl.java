package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookDAOImpl implements BookDAO {
    private Map<Integer, BookDTO> bookList;

    public BookDAOImpl() {
        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1,123445,"자바의 정석","이나짱","한화출판",new Date()));
        bookList.put(2, new BookDTO(2,3434,"도비는 자유","현나이","인생굿",new Date()));
    }

    @Override
    public List<BookDTO> findAllBook() {

        /* 설명. Hash을 ArrayList로 쉽게 바꿀 수 있다.(HashMap -> Collection -> ArrayList */
        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO searchBookBySequence(int sequence) {
        return bookList.get(sequence);
    }
}
