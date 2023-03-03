package baekjoon.graph_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공, dfs, 재귀 사용 **/
public class B2644_촌수계산 {
    static int n;
    static int start;
    static int end;
    static boolean[][] arr;
    static boolean[] visited;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new boolean[n+1][n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int relationCtn = Integer.parseInt(bf.readLine());
        visited = new boolean[n+1];

        for (int i = 0; i < relationCtn; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            arr[from][to] = true;
            arr[to][from] = true;
        }
        dfs(0, start);

        System.out.println(result);
    }

    static boolean dfs(int chonSoo, int current) {

        visited[current] = true;

        if (current == end) {
            result = chonSoo;
            return true;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[current][i] && !visited[i]) {
                if (dfs(chonSoo + 1, i)) {
                    break;
                }
            }
        }

        return false;
    }
}
