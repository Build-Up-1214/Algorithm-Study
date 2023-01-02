import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] visit;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        int count = 0;
        visit = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            if(!visit[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int id) {
        if(visit[id]) return;
        else {
            visit[id] = true;
            for(int i = 1; i <= N; i++) {
                if(graph[id][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}