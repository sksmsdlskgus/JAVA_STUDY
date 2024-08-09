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

    // Application에서 컨테이너를 만드는데 그 범ㅇ주에서 BookSDAOImpl과 BookService가 콩으로 만들어야 한대
    // BookService를 콩으로 만들려고 했는데 bookDAO에 콩을 담으래 근데 콩을 아직 안만들었는데 어케 담노
    // 뭔 개소리냐 ./...?
    public BookService() {

    }

    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    public BookDTO searchBookBySequence(int sequence){
        return bookDAO.searchBookBySequence(sequence);
    }

}
