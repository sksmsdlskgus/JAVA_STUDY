package com.ohgiraffers.chap06.section01.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application4 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][n + 1];
        int[][] p = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i ; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(p[i]));
        }

        /* 설명. p배열을 바탕으로 각 층마다 내려가며 같은 크기의 dp배열 만드는 반복문 */
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {

                /* 설명. dp[i - 1]은 윗층 dp배열, [j - 1]은 왼쪽 위, [j]는 오른쪽 위 */
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + p[i][j];
            }
        }

        /* 설명. dp의 맨 아래층 dp배열에 담긴 값 중 가장 큰 값 추출해서 반환 */
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(ans < dp[n][i]) ans = dp[n][i];
        }

        return ans;
    }
}