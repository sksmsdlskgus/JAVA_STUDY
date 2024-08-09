package com.ohgiraffers.section02.initdestroy;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread(){
        return new Bread("붕어빵2",1000,new java.util.Date());
    }

    @Bean
    public Product milk(){
        return new Beverage(" 딸기우유2",1500,500);
    }

    @Bean
    public Product water(){
        return new Beverage("지리암반수2",3000,1000);
    }

    @Bean
//    @Scope("siglethon")
    @Scope("prototype")
    public ShoppingCart cart(){
        return new ShoppingCart();
    }

    /* 설명. Owner 빈 축사  */
    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner(){
        return new Owner();
    }

}
