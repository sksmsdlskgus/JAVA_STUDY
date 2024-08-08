package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationSection03")
@ComponentScan(basePackages = "com.ohgiraffers.common") //이걸 xml에 집어넣어도 된다 다음 section~
public class ContextConfiguration {


}
