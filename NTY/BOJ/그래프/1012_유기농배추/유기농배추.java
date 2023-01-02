import java.io.*;
import java.util.StringTokenizer;

public class 유기농배추 {
    private static int M, N, flag_count;
    private static int[][] graph;
    private static boolean[][] flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer MNK = new StringTokenizer(br.readLine());
            M = Integer.parseInt(MNK.nextToken());
            N = Integer.parseInt(MNK.nextToken());
            int K = Integer.parseInt(MNK.nextToken());

            graph = new int[M][N];

            for (int j = 0; j < K; j++) {
                StringTokenizer XY = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(XY.nextToken());
                int Y = Integer.parseInt(XY.nextToken());
                graph[X][Y] = 1;
            }

            flag = new boolean[M][N];
            flag_count = 0;
            int count = 0;

            loop:
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (graph[x][y] == 1 && !flag[x][y]) {
                        dfs(x, y);
                        count++;
                        if(flag_count == K) break loop; // 배추 수만큼 다 체크했으면 종료
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int x, int y) {
        flag[x][y] = true;
        flag_count++;
        if (y - 1 >= 0) {   // 상
            if(!flag[x][y - 1] && graph[x][y - 1] == 1) {
                dfs(x, y - 1);
            }
        }
        if (y + 1 <= N - 1) {    // 하
            if(!flag[x][y + 1] && graph[x][y + 1] == 1) {
                dfs(x, y + 1);
            }
        }
        if (x - 1 >= 0) {   // 좌
            if(!flag[x - 1][y] && graph[x - 1][y] == 1) {
                dfs(x - 1, y);
            }
        }
        if (x + 1 <= M - 1) {    // 우
            if(!flag[x + 1][y] && graph[x + 1][y] == 1) {
                dfs(x + 1, y);
            }
        }
    }
}