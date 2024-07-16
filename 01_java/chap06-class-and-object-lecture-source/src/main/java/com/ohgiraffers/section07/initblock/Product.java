package com.ohgiraffers.section07.initblock;

public class Product {
    private String name = "아이폰"; //명시적 초기화     // 상품명
    private int price;          // 상품가격
    private static String brand;        // 제조사
    //private static final String brand; static이면서 함수

    { // 초기화 블록
        System.out.println("초기화 블럭 실행...2번 실행");
        this.name = "헬쥐폰";
        brand = "헬쥐";
    }

    static { // 정적 필드만 초기화 가능
        System.out.println("초기화 블럭 실행...1번 실행");
//        name = "싸이온";
        brand  = "엘지";
    }

    public Product() {
        System.out.println("Product 기본생성자 호출됨...3번 실행");
        name = "아이뽕";
        brand = "한화";
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + this.name + '\'' +
                ", price=" + this.price +
                ", brand='" +Product.brand + '\'' +
                '}';
    }
}
