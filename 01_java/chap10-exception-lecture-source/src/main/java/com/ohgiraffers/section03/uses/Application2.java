package com.ohgiraffers.section03.uses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. try-with-resource 구문을 이해하고 활용할 수 있다. (feat.finally 안 쓰기) */
        try (BufferedReader br = new BufferedReader(new FileReader("test.dat"))) {

        } catch (FileNotFoundException e) { // 자식예외
            e.printStackTrace(); // 비워두지말고 이거라도 써야함
        } catch (IOException e) { // 부모예외
            throw new RuntimeException(e);
        }
    }
}
