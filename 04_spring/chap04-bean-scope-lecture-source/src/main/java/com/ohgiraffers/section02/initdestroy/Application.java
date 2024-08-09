package com.ohgiraffers.section02.initdestroy;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        /* 설명. 붕어빵, 딸기우유, 지리산 암반수 진열*/
        Product cartBread = context.getBean("cartBread", Bread.class); //다형성에 의해 Product에 담는것이 가능하다.
        Product cartMilk = context.getBean("milk", Beverage.class);
        Product cartWater = context.getBean("water", Beverage.class);

        /* 설명. 첫번째 손님이 쇼핑카트를 꺼내 물건을 담는다.  */
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(cartBread);
        cart1.addItem(cartMilk);

        /* 설명. 첫번째 손님의 쇼핑 카트에 담긴 물품 확인 */
        System.out.println("cart1에 담긴 물품: " + cart1.getItems());


        /* 설명. 두번째 손님도 쇼핑카트를 꺼내 물건을 담는다. */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(cartWater);

        System.out.println("cart2에 담긴 물품: " + cart2.getItems());
        System.out.println(System.identityHashCode(cart1) == System.identityHashCode(cart2));

        /* 설명. .컨테이너를 강제종료 시키며 빈이 소멸되게 윧ㅎ */
        ((AnnotationConfigApplicationContext)context).close();
    }
}
