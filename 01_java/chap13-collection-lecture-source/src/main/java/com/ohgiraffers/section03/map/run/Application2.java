package com.ohgiraffers.section03.map.run;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. Properties에 대해 이해하고 활용할 수 있다. */
        /* 설명.
         *   Properties란?
         *    HashMap과 거의 유사하지만 key와 value 모두를 String으로만 사용할 수 있는 자료구조이다.
         *    (제네릭을 별도로 요구하지 않음)
         *    주로 설정 파일 관련된 파일과의 입출력에 사용된다.(store,load 등)
         *  */

        Properties prop = new Properties();

        prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:XE");
        prop.setProperty("user", "swcamp");
        prop.setProperty("password", "swcamp");

        System.out.println("prop = " + prop);

        /* 설명. Properties를 활용한 설정정보 파일로 출력해보기 */
        try {
//            prop.store(new FileOutputStream("drivaer.dat"),"jdbc.driver");
        prop.storeToXML(new FileOutputStream("driver.xml"),"jdbc driver xml version");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 저장된 설정 파일에서부터 읽어온 데이터를 담을 새로운 Properties 객체 */
        Properties prop2 = new Properties();
        System.out.println("읽어오기 전:  " + prop2);

        try {
//            prop2.load(new FileInputStream("drivaer.dat"));
        prop2.load(new FileInputStream("driver.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("읽어온 이후 ===========================");
        System.out.println("driver = " + prop2.getProperty("driver"));
        System.out.println("url = " + prop2.getProperty("url"));
        System.out.println("user = " + prop2.getProperty("user"));
        System.out.println("password = " + prop2.getProperty("password"));



    }
}
