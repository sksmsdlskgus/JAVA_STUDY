package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* 설명. 같은 component-scan 범위 안에 같은 타입에 같은 이름으로 두개 이상의 bean이 공존할 수 없다.(다른 이름 지정) */
@Service("bookServiceConstructor")
public class BookService {

    private BookDAO bookDAO;

    public BookService() {

    }

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }


    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    public BookDTO searchBookBySequence(int sequence){
        return bookDAO.searchBookBySequence(sequence);
    }

}
