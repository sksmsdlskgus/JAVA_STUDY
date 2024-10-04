package com.ohgiraffers.bootproject.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig  implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) { //서블릿 기반에서만 작동하고 , 게이트 웨이에서는 안먹힌다.
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") //모든 요청에서 어떤 프론트 origin 을 허용해줄까
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // 이러한 요청들을 허용하겠다 라는말임
    }
}
