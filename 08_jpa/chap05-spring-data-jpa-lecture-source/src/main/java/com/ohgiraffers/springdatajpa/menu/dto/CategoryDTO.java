package com.ohgiraffers.springdatajpa.menu.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {

    private int categoryCode;

    private int categoryName;

    private int refCategoryCode;
}
