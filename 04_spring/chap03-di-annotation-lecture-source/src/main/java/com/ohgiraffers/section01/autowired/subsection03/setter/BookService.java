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

    /* 설명.
    *   bookDAO 타입의 빈 객체를 생성자를 통해 주입 받는것을 생성자 주입일라고 한다.(기본생성자는 활용 X)
    *
    *  설명.
    *   생성자 주입의 이점
    *   1. 필드에 final 키워들를 사용할 수 있다.
    *   2. 순환참조를 스프링 시작 시점에 파악하여 방지할 수 있다.
    *   3. 필드 주입과 setter 주입의 단점(@Autowired를 남용, 자바 reflection기술을 통해 캡슐화 적용 X, 불변객체를 만들 수 X)
    *   4. 테스트 코드 시에 생성자를 통해 편하게 테스트 할 수 있다. (Mack 객체 생성 불필요)
    * */

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
