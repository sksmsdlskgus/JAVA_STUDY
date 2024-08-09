package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
//    BookDAO bookDAO = new BookDAOImpl();
// BookService가 콩이 되게 @Service 달아서 만들어야함 그래야 콩인 BookSDAOImpl인 콩을 넣을 수 있음]
// BookSDAOImpl도 콩으로 만들어야함 @Repository를 달아 콩으로 만들자

    @Autowired
    BookDAO bookDAO;
    // 위에꺼 = 필드 주입
    // private BookDAO bookDAO;로 해도 작동된다. 다른 패키지에서 뚫고 들어오는거라 지양함
    public BookService() {

    }

    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    public BookDTO searchBookBySequence(int sequence){
        return bookDAO.searchBookBySequence(sequence);
    }

}
