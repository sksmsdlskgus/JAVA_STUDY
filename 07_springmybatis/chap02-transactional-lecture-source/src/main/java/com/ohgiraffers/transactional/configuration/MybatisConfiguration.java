package com.ohgiraffers.transactional.configuration;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ohgiraffers.transactional",annotationClass = Mapper.class)
// Mapper의 어노테이션을 달은 애를 Mapper로 스캔해라
public class MybatisConfiguration {
}
