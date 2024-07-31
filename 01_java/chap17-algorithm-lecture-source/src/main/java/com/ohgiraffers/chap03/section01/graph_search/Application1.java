package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;


/* 수업목표. DFS를 활용(재귀함수)하는 예제를 이해할 수 있다. */
/* 필기.
*    깊이 우선 탐색(Depth-First Search)
*     후입선출 구조에 stack 또는 재귀함수를 활용한다.
*      한쪽 분기를 정하여 최대 깊이까지 탐ㅅ객 후 분기를 이동항여 다시 탐색하는 알고리즘이다.*/
public class Application1 {

    static boolean[] visit;  // 방문배열
    static int[][] map;   // 그래프를 2차원 배열로 매칭(인접리스트)
    static int count = 0;   // 오염된 컴퓨터의 수
    static int node, edge;   // node와 edge의 개념을 저장


    /* 설명. 문자열에서 한 줄 씩 읽어들이기 위한 BufferedReader를 반환하는 메소드(readLine()) */
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());

        return 0 ;
    }
}
