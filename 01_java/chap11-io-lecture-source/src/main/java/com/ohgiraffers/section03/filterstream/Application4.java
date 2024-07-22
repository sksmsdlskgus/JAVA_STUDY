package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {

        MemberDTO[] memArr = new MemberDTO[100];
        memArr[0] = new MemberDTO("user01", "pass01", "홍길동"
                , "hong123@gmail.com", 25, '남');
        memArr[1] = new MemberDTO("user02", "pass02", "유관순"
                , "korea31@gmail.com", 16, '여');
        memArr[2] = new MemberDTO("user03", "pass03", "강감찬"
                , "leesoonsin@gmail.com", 38, '남');


        File ObjFile = new File("src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt");

        ObjectOutputStream objOut = null;
        try {
            if(!ObjFile.exists()) {
                objOut = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt")
                        )
                );
            } else {
                objOut = new MyOutput(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt", true)
                        )
                );
            }

            for(int i = 0; i < memArr.length; i++) {
                if(memArr[i] == null) break;
                objOut.writeObject(memArr[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(objOut != null) objOut.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        MemberDTO[] newMemArr = new MemberDTO[memArr.length];

        ObjectInputStream objIn = null;
        try {
            objIn = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt")
                    )
            );

            int i = 0;
            while(true) {
                newMemArr[i] = (MemberDTO)objIn.readObject();
                i++;
            }
        } catch (EOFException e) {
            System.out.println("객체 단위 파일 입력 완료!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(objIn != null) objIn.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for(MemberDTO m : newMemArr) {
            if(m == null) break;
            System.out.println(m);
        }
    }
}