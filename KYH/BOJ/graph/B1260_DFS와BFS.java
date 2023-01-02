package baekjoon.graph_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공 **/
public class B1260_DFS와BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] edge = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[a][b] = 1;
            edge[b][a] = 1;
        }

        dfs(v, n, edge);
        System.out.println();
        bfs(v, n, edge);
        System.out.println();

    }

    public static void dfs(int startVertex, int vertexCtn, int[][] edge) {

        boolean[] visited = new boolean[vertexCtn+1];

        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.empty()) {

            Integer popVertex = stack.pop();

            if(visited[popVertex])
                continue;

            visited[popVertex] = true;
            System.out.print(popVertex + " ");

            for (int i = vertexCtn; i >= 1; i--) {

                if(edge[popVertex][i] == 1)
                    if(!visited[i])
                        stack.push(i);
            }
        }

        //시작 정점을 스택에 넣는다
        //스택에 정점이 없을때까지 반복
        //  만약 이미 방문한 정점이라면
        //      반복문의 조건문으로 스킵
        //  스택에서 정점을 꺼낸다
        //  visited 배열에 방문 체크한다
        //  결과 배열에 꺼내진 정점을 넣는다
        //  i = 정점갯수 TO 1,꺼내진 정점의 인접 행렬을 끝에서부터 순차 조회한다
        //      만약 i 정점이 인접 행렬이라면
        //          if(visited[i] == false)
        //              스택에 i정점을 넣는다
        //~반복문 종료
    }

    public static void bfs(int startVertex, int vertexCtn, int[][] edge) {

        int idx = 0;
        boolean[] visited = new boolean[vertexCtn+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);


        while (!queue.isEmpty()) {

            int dqVertex = queue.poll();
            if(visited[dqVertex])
                continue;

            visited[dqVertex] = true;
            System.out.print(dqVertex + " ");

            for (int i = 1; i <= vertexCtn; i++) {

                if(edge[dqVertex][i] == 1)
                    if(!visited[i]) {
                        queue.offer(i);
                    }
            }
        }

        //시작 정점을 큐에 넣음
        //큐에 정점이 없을때 까지 반복
        //  dequeueVertex = 큐에서 정점을 꺼냄
        //  방문 배열에 현재 정점 방문체크
        //      i = 1 To 정점 갯수 반복,
        //          만약 edge[dequeueVertex][i] 가 true라면 (인접 정점이라면)
        //              만약 visited[i] false라면 (방문을 아직 안했다면)
        //                  enqueue(i)
        //      ~ 반복문 종료
        //~ 반복문 종료
    }

}
