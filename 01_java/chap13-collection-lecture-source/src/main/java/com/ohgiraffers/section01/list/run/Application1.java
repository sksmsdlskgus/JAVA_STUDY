package com.ohgiraffers.section01.list.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 컬렉션 프레임워크에 대해 이해할 수 있다. (list부터) */
        ArrayList list = new ArrayList();
//        List list = new ArrayList();        //List 계열의 다른 인스턴스로 바껴도 나머지 코드에 영향을 주지
        // 않기 위해서 다형성을 적용한 형태로 많이 쓴다.

        /* 설명. 자료형에 구애받지 않고 데이터를 추가할 수 있다. */
        list.add("apple");
        list.add(123);
        list.add(45.67);
        list.add(new java.util.Date());

        /* 컬렉션들을 toString() 오버라이딩이 잘 되어 있어 출력해 보기 편한 */
        System.out.println("list 한번에 출력:  " + list);

        System.out.println("List.ge(0): " + list.get(0)); // 처음 add한 값
        System.out.println("List.ge(2): " + list.get(2)); // 세번째 add한 값
        System.out.println("List에 담긴 데이터의 크기: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        /* 설명.
         *   배열보다 ArrayList가 나은점
         *   1. 처음부터 크기 할당 불필요
         *   2. 중간에 값 추가 및 삭제가 용이
         *   */

        /* 설명. 배열과 ArrayList를 활용해 각각 원하는 인덱스에 값 추가해보기 */
        int[] intArr = new int[5];
        int num = 0;
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = num++;
        }

        System.out.println(Arrays.toString(intArr));

        int[] newArr = new int[intArr.length + 1];
        System.arraycopy(intArr, 0, newArr, 0, intArr.length);
        System.out.println(Arrays.toString(newArr));

        /* 설명. 2번 인덱스 위피에 7을 끼워넣기  */
        for (int i = newArr.length - 2; i > 1; i--) {
            newArr[i + 1] = newArr[i];
        }

        System.out.println(Arrays.toString(newArr));
        newArr[2] = 7;
        System.out.println(Arrays.toString(newArr));

        /* 설명. ArrayList에서 제공하는 add()메소드로 쉽게 해보자. */
        ArrayList<Integer> intArrList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            intArrList.add(i + 1);
        }
        System.out.println(intArrList);
        intArrList.add(2, 7);        // 매게변수 2개짜리 add 메소드를 활용
        System.out.println(intArrList);

        /* 설명. ArrayList에는 중복(동등(e,h))값이 허용된다. */
        System.out.println(list);
        list.add("apple");
        list.add(123);
        System.out.println(list);

        /* 설명. ArrayList가 관리하는 값을 수정하려면 set()메소드를 활용한다. */
        list.set(1 , 777);
        System.out.println(list);

        /* 설명. ArrayList가 관리하는 값을 삭제하려면 remove()메소드를 활용한다. */
        list.remove(0);
        System.out.println(list);

        list.add(null);
        System.out.println(list);


        /* 설명. ArrayList를 활용한 정럴 */
        /* 설명. 1.문자열 데이터 정렬 */
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("orange");
        stringList.add("grape");
        stringList.add("pineapple");

        System.out.println("stringList = " + stringList);

        /* 설명. ArrayList 안에 들어있는 데이터 타입(String)에 정의된 정렬 기준대로 정렬 */
        Collections.sort(stringList);       //String에는 문자열 오름차순(Ascending)에 대한 정의가 되어있음
        System.out.println("stringList = " + stringList);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        System.out.println("integerList = " + integerList);

        Collections.sort(integerList);
        System.out.println("integerList = " + integerList);

        /* 설명. 내림차순으로 바꾸기 위해 ArratList에서 LinkedList로 교체*/
        stringList = new LinkedList<>(stringList);

        /* 설명. Iterator(반복자)는 hashNext()와 next()를 활용해 들어있는 data를 반복 시킬 수 있는 타입이다.
        *   설명. 다루는 Iterator와 관련된 컬렉션의 제네릭 타입과 일치하는 제네릭을 꼭 써주나!(다운 캐스팅 고민없도록) */
        Iterator<String> iter = ((LinkedList<String>) stringList).descendingIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }

    }
}
