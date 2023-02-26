package baekjoon.graph_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 성공, bfs사용 **/
public class B11724_연결요소의개수 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];
        boolean[][] arr = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v] = true;
            arr[v][u] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        int result = 0;

        for (int i = 1; i <= n; i++) {

            if (visited[i] == false) {
                queue.offer(i);

                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();

                    for (int j = 1; j <= n; j++) {

                        if (arr[poll][j] && !visited[j]) {
                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                }
                result++;
            }
        }

        System.out.println(result);

    }
}
