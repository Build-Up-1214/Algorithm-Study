import java.io.*;
import java.util.StringTokenizer;

public class 바이러스 {
    private static int N, M, flag_count;
    private static int[][] graph;
    private static boolean[] flag;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 컴퓨터 수
        M = Integer.parseInt(br.readLine());    // 연결 수

        graph = new int[N][N];  // 그래프
        for (int i = 0; i < M; i++) {   // 그래프에 연결 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            graph[x][y] = graph[y][x] = 1;
        }

        flag = new boolean[N];  // 컴퓨터 바이러스 걸린 상태
        flag_count = 0; // 바이러스 걸린 컴퓨터 카운트
        dfs(0); // DFS로 탐색

        System.out.println(flag_count - 1);    // 1번 컴퓨터(첫번째) 제외
    }

    // DFS
    private static void dfs(int start) {
        flag[start] = true;
        flag_count++;
        for(int i = 0; i < N; i++) {
            if (graph[start][i] == 1 && !flag[i]) dfs(i);
        }
    }
}