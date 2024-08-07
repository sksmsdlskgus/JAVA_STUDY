package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /* 설명. 'password'라는 키 값이 들어오면 암호화를 하는 우리만의 getParameter 메소드 재정의 */
    @Override
    public String getParameter(String key) {

        String value = "";
        if("password".equals(key)) {        // 키 값이 'password'일 경우 다이제스트(암호화 된 값)을 반환할 문자열로 저장
            System.out.println("패스워드 꺼낼 시!!");
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter("password"));
        } else {                            // 그 외의 키 값을 사용할 경우 기존대로 동작
            value = super.getParameter(key);
        }

        return value;
    }
}