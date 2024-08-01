package com.ohgiraffers.chap05.section01.tree;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 수업목표. 트리(tree) 알고리즘을 활용하는 예제를 이해할 수 있다.*/
/* 필기.
*   그래프에서 계층적인 구조를 나타내기 위해 최상위 노드인 루트(root)노들에서 시작하여
*    하위 노드들로 분기하는 방식으로 구성된 알고리즘이다. */
public class Application1 {

    static int N;
    static int[] parent;
    static boolean[] isVisit;
    static StringTokenizer st;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }


    public static String solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        sb.delete(0, sb.length());      // 알고리즘과는 무관하나 테스트 코드 환경이라 작성


        //첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다
        N = Integer.parseInt(br.readLine()); // 입력값을 받아 노드에 넣어줌
        isVisit = new boolean[N + 1];
        list = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i < N +1; i++) {
            list[i] = new ArrayList<>(); // 아직 안담더라도 객체는 만들어놔야해 이거 까먹는 경우가 많음
        }

        /* 설명. N-1 줄의 입력을 처리 */
        for (int i = 1; i < N; i++) { //둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 양방향 배열 세팅
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b); //list a번째에는 b가 담겨있고.
            list[b].add(a); //list b번째에는 a가 담겨있다.

        }

        dfs(1); //트리의 루트를 1이라고 정했을 때,

        /* 설명. dfs이후 parent노드에는 각 노드의 부모 노드가 담겨있다. */
        /* 설명. 2번 노드부터 부모노드들을 하나의 문자열로 반환 */
        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]);
            sb.append(" ");

        }

        return sb.toString();
    }

    private static void dfs(int parentNode) { // 던져진 1이 부모다.

        /* 설명. 이미 방문한 노드들은 부모 노드들이고 부모노드들은 재방문하지 않도록 함 */
        isVisit[parentNode] = true;


        /* 설명. 입력받은 값을 통해 생성된 list(관련있는 노드들)로부터 정보 확인 */
        for (int node : list[parentNode]) { // 부모가 넘어왔을때 관련 노드를 찾는
            if(!isVisit[node]) { //방문하지 않았다면

                // 이 줄 부터는 던져진 1로 부터 childnode를 의미
                parent[node] = parentNode; // 방금 넘어온 노드를 부모 노드로 설정
                dfs(node); // 그 노드를 다시 dfs로 반복 후 끝을 찍으면 위로 continue;
            }
        }

    }
}
