package com.ohgiraffers.transactional.section01.annotation;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/* 설명. 테이블에 꼭 일치하지 않더라도 주문을 위해 사용자가 넘겨준 값을 담을 수 있는 DTO클래스 */
/* 설명. DTO(Data Tensfer Object) : 계층을 넘어다니며 값을 옯겨주는 클래스 */
public class OrderDTO {
     private LocalDateTime orderDate;
     private LocalTime orderTime;
     private List<OrderMenuDTO> orderMenus;

    public OrderDTO() {
    }

    public OrderDTO(LocalDateTime orderDate, LocalTime orderTime, List<OrderMenuDTO> orderMenus) {
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderMenus = orderMenus;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderMenuDTO> getOrderMenus() {
        return orderMenus;
    }

    public void setOrderMenus(List<OrderMenuDTO> orderMenus) {
        this.orderMenus = orderMenus;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDate=" + orderDate +
                ", orderTime=" + orderTime +
                ", orderMenus=" + orderMenus +
                '}';
    }
}
