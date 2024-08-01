package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application3_1 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        int max_count = 0;

        BufferedReader br = new BufferedReader(toBufferedReader(input));
        int N = Integer.parseInt(br.readLine());   // 회의 수 입력 받기
        int[][] time = new int[N][2]; // 회의 갯수 * (시작/종료 시간) | 2차원 배열로 회의 시작과 종료시간 관리

        StringTokenizer str;
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            time[i][0] = Integer.valueOf(str.nextToken()); // 시작시간
            time[i][1] = Integer.valueOf(str.nextToken()); // 종료시간
        }

        /* 설명. o1/o2는 각각의 회의를 뜻하고 두개의 회의가 람다식에 넘어옴
        *    결과적으로 이차원 배열 (time)이 정렬됨*/
        Arrays.sort(time,(o1,o2)-> { // o1가 i번째이면 o2가 i+1번째를 의미

           /* 설명. 종료시간이 같은 회의에 대해서는 */
            if(o1[1] == o2[1]){  // 회의 종료시간이 같다면 조건문 실행
                return o1[0] - o2[0]; //시작 시간에 대한 내림차순 (늦게 시작하는 회의 일 수록)
            }

            /* 설명. 종료시간이 같지 않는 회의에 대해서는  */
            return o1[1] - o2[1]; //종료 시간에 대한 오름차순(일찍 끝나는 회의일 수록)
        });

        /* 설명. 앞선 회의가 끝나는 시간을 담아놓을 변수 */
        int end = 0;

        /* 설명. time 배열 (정렬 된)에 담긴 회의들을 확인하며 앞선 회의의 종료 다음에 열리는 회의를 판별하며 count증가 */
        for (int i = 0; i < N; i++) {

            /* 설명. 최소한 앞선 회의가 끝나는 시간과 일치하거나 이후 시작되는 회의인가 */
            if(end <= time[i][0]){

                /* 설명. 조건을 만족하는 회의(열릴 수 있는 다음 회의)의 종료 시간으로 end를 갱신 */
                end = time[i][1];
                max_count++;
            }
        }


        return max_count;
    }
}
