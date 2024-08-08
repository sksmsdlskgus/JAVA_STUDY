package com.ohgiraffers.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MemberDTO {
    private int sequence;
    private String id;
    private String pwd;
    private String name;
}
