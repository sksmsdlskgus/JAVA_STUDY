package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. FileOutStream에 대해 이해하고 활용할 수 있다. */
        FileOutputStream fout = null;
        try {

            /* 설명. 해당 경로에 파일이 없으면 만들어 줌(출력 스트림만 만들어도) */
            /* 설명. OutputStream 생성자 중에 append 개념을 추가하는 인자를 true로 넘겨주면 데이터 이어붙이기가 가능하다. */
            fout = new FileOutputStream("src/main/java/com/ohgiraffers/section02/stream/testOutputStream.txt",true);
            //true 넣으면 새로고침 시, 누적 | 안넣으면 리셋

//            fout.write('a');
//            fout.write(66);

            byte[] bArr = new byte[]{'a', 'p', 'p','l','e'};
            for (byte b : bArr) {
                fout.write(b);
            }

            fout.write(bArr,1,3);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(fout != null) fout.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
