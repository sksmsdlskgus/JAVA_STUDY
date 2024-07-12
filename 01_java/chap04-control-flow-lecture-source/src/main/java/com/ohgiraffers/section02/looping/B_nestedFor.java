package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTowToNine() {

        /* 설명.
         *  2단
         *   2 * 1 = 2
         *   2 * 2 = 4
         *   2 * 3 = 6
         *   ...
         *  3단
         *   3 * 1 = 3
         *   3 * 2 = 6
         *   3 * 3 = 9
         *   ...
         *   9 * 9 = 81
         * */

        for (int i = 2; i < 10; i++) {              // 단(행, row)
            System.out.println(i + "단 곱셈");
            printGugudanOf(i);
            System.out.println();
        }
    }

    /* 설명. 단수를 넘겨주면 해당 단수의 곱셈 출력 기능 메소드 */
    private static void printGugudanOf(int dan) {
        for (int j = 1; j < 10; j++) {          // 수(컬럼, column)
            System.out.println(dan + " * " + j + " = " + (dan * j));
        }
    }

    /* 설명.
     *  아래와 같은 별모양이 나오도록 작성해 보자.
     *  정수를 입력하시오: 5
     *      *
     *     **
     *    ***
     *   ****
     *  *****
     * */
    public void printStars() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오: ");
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            placeSpace(input, i);
            placeStars(i);
            System.out.println();
        }

    }

    /* 설명. 두 가지 전달인자를 활용한 공백 출력 기능의 메소드 */
    private static void placeSpace(int input, int i) {
        for (int j = 0; j < input - (i + 1); j++) {
            System.out.print(" ");
        }
    }

    /* 설명. int값을 주면 int값의 수만큼 옆으로 *을 찍는 기능의 메소드 */
    private static void placeStars(int i) {
        for (int j = 0; j < (i + 1); j++) {
            System.out.print("*");
        }
    }

    /* 설명.
     * 정수를 입력하세요: 5
     *     *
     *    **
     *   ***
     *  ****
     * *****
     * */

}