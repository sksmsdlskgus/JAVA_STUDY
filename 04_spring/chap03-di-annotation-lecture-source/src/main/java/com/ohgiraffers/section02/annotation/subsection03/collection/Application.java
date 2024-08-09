package com.ohgiraffers.section02.annotation.subsection03.collection;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        PokemonService ps = context.getBean("pokemonServiceCollection", PokemonService.class);
        ps.pokemonAttack();
    }
}
