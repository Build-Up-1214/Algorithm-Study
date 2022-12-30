import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int count = 0;
    static int[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        visit = new boolean[N + 1];
        dfs(1);
        System.out.println(count - 1); // 1번 컴퓨터 제외해야하므로 -1
    }
    public static void dfs(int id) {
        visit[id] = true;
        count++;
        for(int i = 1; i <= N; i++) {
            if (graph[id][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}