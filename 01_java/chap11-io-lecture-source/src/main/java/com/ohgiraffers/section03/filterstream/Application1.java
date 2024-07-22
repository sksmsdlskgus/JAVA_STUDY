package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. BufferedWriter와 BufferedReader에 대해 이해하고 사용할 수 있다.*/
        /* 설명.
        *    내부적으로 버퍼(buffer)를 활용해서 입출력 성능을 향상시킨다
        *    추가적인 메소드가 제공된다.
        *  */

        /* 설명. BufferedWriter를 활용한 한줄 씩 출력하기 */
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter("src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt",true));
            bw.write("제목: 이나현바보\n");
            bw.write("어쩔티비 안농안농~\n");
            bw.write("이나현 체고\n");

            /* 설명.
            *   버퍼를 이용해서 출력을 하는 경우 버퍼 공간이 가득차지 않으면 내보내기(출력)가 안되는 경우가 있다.
            *   이럴 경우 버퍼에 담긴 내용을 강제로 내보내기 위해서는 flush()메소드를 활용해야한다.
            *    (write를 했는데 파일에 값이 안 적혀 있으면 flush()할 것)*/
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
      }
//        finally {
//            try {
//                /* 설명. 보조스트림을 닫으면 그 이전에 (내부에) 만든 스트림들은 자동으로 close()된다. */
//                if (bw != null){
//                    bw.close();     //BufferedWriter 스트림을 닫으면 내부적으로 flush()가 동작한다.
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        /* 설명. BufferedReader를 활용한 한 줄 (가행 문자 전까지) 씩 읽어오기 */
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt"));

            String rstr = "";
            while ((rstr = br.readLine()) != null) {
                System.out.println(rstr);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(br != null) br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
