package com.ohgiraffers.userservice.dto;

import com.ohgiraffers.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String email;
    private String name;
    private String pwd;
    
    /* 설명. ServiceImpl 계층에서 고유 회원 생성하며 추가(응답할 때도 활용) */
    private String userId;

    /* 설명. FeignClient 이후(주문내역도 담기) */
    private List<ResponseOrder> orders;

}
