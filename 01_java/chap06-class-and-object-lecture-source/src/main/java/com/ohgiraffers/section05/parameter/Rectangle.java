package com.ohgiraffers.section05.parameter;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle() {
    }

    public Rectangle(int height, int width) {
        this.width = width;
        this.height = height;
    }

    public void calArea(){
        System.out.println("사각형의 넓이는 " + (this.width * this.height));
    }

    public void calRound(){
        System.out.println("사각형의 둘레는 " + (this.width + this.height) * 2);

    }
}
