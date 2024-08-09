package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import com.ohgiraffers.section02.initdestroy.Owner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {

    @Value("${bread.carpbread.name}")
    private String carpBreadName;

    @Value("${bread.carpbread.price}")
    private int carpBreadPrice;

    @Value("${beverage.milk.name}")
    private String milkName;

    @Value("${beverage.milk.price}")
    private int milkPrice;

    @Value("${beverage.milk.capacity}")
    private int milkCapacity;

    @Value("${beverage.water.name}")
    private String waterName;

    @Value("${beverage.water.price}")
    private int waterPrice;

    @Value("${beverage.water.capacity}")
    private int waterCapacity;


    @Bean
    public Product carpBread() {
        return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    public Product water() {
        return new Beverage(waterName, waterPrice, waterCapacity);
    }



    @Bean
//    @Scope("singleton")     // 스프링 컨테이너(IOC Container)는 bean 객체를 기본적으로 싱글톤으로 관리한다.(생략 가능)
    @Scope("prototype")     // 빈 스코프를 수정하게 되면 bean 객체의 life cycle을 다른 주기로 가져갈 수 있다.
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

    /* 설명. Owner 빈 추가, 빈의 생성 및 소멸 시점에 자동 호출 될 메소드를 등록할 수 있다. */
    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner onwer() {
        return new Owner();
    }

}
