package com.ohgiraffers.section03.filterstream;


import java.io.*;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 데이터 타입 입출력 보조 스트림을 이해하고 활용할 수 있다. */
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testData.txt"));

            dos.writeUTF("홍길동");
            dos.writeInt(20);
            dos.writeChar('A');

            dos.writeUTF("유관순");
            dos.writeInt(16);
            dos.writeChar('B');

            dos.writeUTF("강감찬");
            dos.writeInt(38);
            dos.writeChar('O');

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dos != null)
                    dos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/testData.txt"));
            while (true) {
                System.out.println(dis.readUTF());
                System.out.println(dis.readInt());
                System.out.println(dis.readChar());

            }

        } catch (EOFException e) {

            /* 설명. data 단위 입출력은 EOFException을 활용하여 파일의 끝까지 입력 받았다는 것을 처리할 수 있다. */
            System.out.println("파일을 다 읽어냄");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dis != null)
                    dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
