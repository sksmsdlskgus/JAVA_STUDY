package com.ohgiraffers.bootproject.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // 이거 두개 주석처리를 한다면 포조 형태로 변함
public class WebConfig  implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) { //서블릿 기반에서만 작동하고 , 게이트 웨이에서는 안먹힌다.
        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:5173") //모든 요청에서 어떤 프론트 origin 을 허용해줄까
//                Ingress 적용 이전 프론트 워커노드 포트에 대한 CORS 처리
//                .allowedOrigins("http://localhost:30000")

//                Ingress 적용 이후 CORS 불필요로 인한 경로 제거
                .allowedOrigins()
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // 이러한 요청들을 허용하겠다 라는말임
    }
}
