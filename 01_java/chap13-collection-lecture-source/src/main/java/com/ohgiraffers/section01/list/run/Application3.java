package com.ohgiraffers.section01.list.run;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. List 계열을 출력하는 4가지 방법 */
        /* 수업목표. LinkedList에 대해 이해할 수 있다. */
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");

        /* 설명. 1.toString() 활용하기 */
        System.out.println("arrayList = " + arrayList);

        /* 설명. 2.for문 활용하기 */
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        /* 설명. 3. for-each문 활용하기 */
        for (String string : arrayList) {
            System.out.println(string);
        }

        /* 설명. 4. iterator 활용하기 */
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        /* 설명. 1번 인덱스(2번째)의 과일 수정 */
        arrayList.set(1,"pineapple");
        System.out.println("arrayList = " + arrayList);

        /* 설명.  list가 관리하는 요소를 제거*/
        arrayList.remove(2);   // LinkecList는 ArrayList와 달리 부분적인 요소 제거에서 성능이 우수하다.
        System.out.println("arrayList = " + arrayList);
        arrayList.clear();     // 전체 요소들 제거
        System.out.println("arrayList = " + arrayList);

        /* 설명. 요소가 없는 list계열인지 확인 */
        System.out.println("isEmpty = " + arrayList.isEmpty());

//        ArrayList:
//        - 내부적으로 배열을 사용.
//        - 인덱스 기반 접근이 빠름 (O(1)).
//                - 중간 삽입 및 삭제가 느림 (O(n)).
//                - 메모리 사용이 효율적.
//
//        LinkedList:
//        - 내부적으로 이중 연결 리스트를 사용.
//        - 인덱스 기반 접근이 느림 (O(n)).
//                - 중간 삽입 및 삭제가 빠름 (O(1)).
//                - 추가 메모리 사용 (노드 객체와 참조 변수).
//
//        결론:
//        ArrayList는 읽기 및 인덱스 기반 접근이 많은 경우에 유리
//        LinkedList는 삽입 및 삭제가 빈번히 발생하는 경우에 유리

    }
}
