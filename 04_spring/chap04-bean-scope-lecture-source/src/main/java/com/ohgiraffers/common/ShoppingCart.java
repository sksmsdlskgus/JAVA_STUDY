package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart  {

    private final List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    } // 하나의 저장공간 이 객체 하나만 쓰겠다는 의미

    /* 설명. 쇼핑카트에 물품을 담거나 꺼내는 기능 */
    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItems() {
        return items;
    }


}
