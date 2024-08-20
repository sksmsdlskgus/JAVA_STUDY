package com.ohgiraffers.transactional.section01.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    /* 설명. sqlSession.getMapper() 대신 @Mapper가 달려 하위 구현체가 관리되면 의존성 주입 받을 수 있다. */
    private OrderMapper orderMapper;
    // 주문도 할거고 메뉴도 가져올거다

    @Autowired
    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /* 설명.
     *   OrderDTO에 담겨 컨트롤러에서 넘어온다는 가정
     *   : Service계층 부터 개발할 떄는 사용자가 입력한 값들이 어떻게 DTO 또는  Map으로 묶여서 Controller로부터
     *    넘어올 지 충분히 고민 한 후 매개변수로 작성하고 개발한다.
     *    현재의 경우(주문 한건 발생) 사용자가 고른 메뉴들 각각의 코드 번호화 고른 메뉴 갯수, 그리고 서버의 현재시간이
     *    담긴 채로 넘어왔다는 생각을 가지고 개발해 나가자.
     *  */

    public void registNewOrder(OrderDTO orderInfo) {
        /* 설명. 1. 주문한 메뉴 코드 추출(DTO에서) */
        List<Integer> menuCode2 = orderInfo.getOrderMenus()
                                            .stream()
                                            .map(OrderMenuDTO::getMenuCode)
                                            .collect(Collectors.toList());

        List<Integer> menuCode = new ArrayList<>();
        List<OrderMenuDTO> orderMenus = orderInfo.getOrderMenus();
        for (OrderMenuDTO orderMenu : orderMenus) {
            menuCode.add(orderMenu.getMenuCode());
        }

        menuCode2.forEach(System.out::println);
        menuCode.forEach(System.out::println);


        /* 설명. 2. 주문한 메뉴 별로 Menu엔티티에 담아서 조회(select)해오기 (부가적인 메뉴의 정보 추출(단가 등( */
        /* 설명. 3. 이 주문건에 대한 주문 총 합계를 계산(insert 한번으로 처리하기 위해..) */
        /* 설명. 4. 1부터 3까지를 하면 tbl_order 테이블에 추가 (insert)가 가능 */
        /* 설명. 5. tbl_order_menu에도 주문한 메뉴 갯수만큼 주문한 메뉴를 추가(insert)한다. */
    }

}
