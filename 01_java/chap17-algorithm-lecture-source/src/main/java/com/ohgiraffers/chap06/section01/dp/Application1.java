package com.ohgiraffers.chap06.section01.dp;

import java.io.IOException;

/* 수업목표. 동적계획법(Dynamic Programming)알고리즘을 활용하는 예제를 이해할 수 있다. */
/* 필기.
*   복잡한 전체 문제를 작은 부분 문제에 대한 최적의 해결방법을 고안(누적)하며 해결하는 알고리즘이다.
*   규칙이 보이는 구간들에 대한 점화식을 세워 작은 문제들을 해결하면 전체 문제의 최적의 값이 나오게 된다.
* */
public class Application1 {
    public static int solution(int N) throws IOException {
        int[] dp = new int[N+1];

        /* 설명. dp 배열의 5번 인덱스까지에 대한 처리(0KG부터 5KG까지의 범위에 대한 초기화 */
        if(N >= 3) dp[3]=1;
        if(N >= 5) dp[5]=1;

        for (int i = 6; i <= N; i++) {
            if(i % 5 == 0){
                dp[i] = dp[i-5] +1;     // 5kg 봉지 추가
            } else if(i % 3 == 0){
                dp[i] = dp[i-3] +1;     // 3kg 봉지 추가
            }

            /* 설명. 한 종류가 아닌 봉지들로 설탕을 처리하는 경우 */
            else {

                /* 설명. 3 또는 5의 배수 구간이 아니지만 3또는 5킬로 봉지로 해결할 수 있는 경우 (ex. 17kg, 23kg) */
                if(dp[i-3] !=0 && dp[i-5]!=0) {
                  dp[i] = Math.min(dp[i-3], dp[i-5])+1;
                }
            }
        }

        if(dp[N]==0) return -1;

        return dp[N];
    }
}
