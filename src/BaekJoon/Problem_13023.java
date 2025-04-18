/*BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.
위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.

둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

출력
문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
그러니까 ABCDE 가 이어져라 == depth 가 인원수와 같아야 한다
**/
package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Problem_13023 {
    List<Integer>[] graph; //이 코드에서 List를 배열로 가지겠다라는 의미인 것이다. 즉 graph[1]는 리스트를 의미한다.
    boolean[] visited;
    int N, M;
    boolean found = false;

    public Problem_13023() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }

    private void dfs(int now, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        visited[now] = true;
        for (int next : graph[now]) { //now 노드에 해당하는 리스트를 순환한다. 즉 인접 노드들을 탐색
            if (!visited[next]) {//해당 노드가 방문하지 않은 것이라면
                dfs(next, depth + 1);
                if (found) return;
            }
        }
        visited[now] = false;// 맨 첨 start에 인접 노드들을 초기화 하기 위해서
    }
}
