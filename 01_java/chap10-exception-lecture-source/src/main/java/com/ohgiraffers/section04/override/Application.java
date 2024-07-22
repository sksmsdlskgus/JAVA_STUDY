package com.ohgiraffers.section04.override;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        SuperClass sc = new SuperClass();
        try {
            sc.method();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
