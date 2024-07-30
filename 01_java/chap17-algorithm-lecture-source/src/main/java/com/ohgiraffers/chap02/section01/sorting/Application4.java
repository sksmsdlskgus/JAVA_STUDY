package com.ohgiraffers.chap02.section01.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/* 수업목표. 퀵 정렬을 이해할 수 있다.  */
/* 필기.  
*   퀵 정렬(quick Sort)
*    기준값을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것ㅇ=을 반복해서 정렬하는 것으로 
*    병합 알고리즘과 함께 실제 정렬 알고리즘으로 많이 활용되고 있다. 
*     시간 복잡도 O(nlogn)이지만 최악의 경우는 O(n^2)이다.
* */
public class Application4 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
             int length = Integer.parseInt(br.readLine());
            IntStream intStream = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt);
            int[] arr  = intStream.toArray();
            
            solution(0, arr.length-1, arr);
            
            for (int i:arr){
                System.out.println( i + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solution(int low, int high, int[] arr) {
        if(low >= high){
            return;
        }

        /* 설명. low 와 high 포인터를 이용해서 low가 high를 지나칠 때까지 한 사이클 */
        int pivot = process(low,high,arr);

        solution(low,high,arr);
        solution(low+1,high,arr);
    }

    /* 설명. low에 해당하는 포인터와 high에 해당하는 표인터를 최대한 움직여 pivot 반환하는 메소드 */
    private static int process(int low, int high, int[] arr) {
        return 0;
    }
}
