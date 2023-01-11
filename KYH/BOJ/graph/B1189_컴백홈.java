package baekjoon.graph_그래프.dfs_깊이우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/** 성공 **/
public class B1189_컴백홈 {

    static int[] dC = {0,0,-1,1};
    static int[] dR = {-1,1,0,0};
    static char[][] map;
    static int k;
    static boolean[][] visited;
    static int r;
    static int c;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = bf.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited[r-1][0] = true;
        dfs(r-1,0, 1);

        System.out.println(result);
    }
    private static void dfs(int curR, int curC, int count) {

        if (curR == 0 && curC == (c - 1)) {
            if(count == k)
            {
                result++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {

            int nextR = curR + dR[i];
            int nextC = curC + dC[i];

            if (nextR >= 0 && nextR <= (r - 1) && nextC >= 0 && nextC <= (c - 1)) {
                if (visited[nextR][nextC] == false && map[nextR][nextC] == '.') {
                    if(count+1 <= k)
                    {
                        visited[nextR][nextC] = true;
                        dfs(nextR, nextC, count+1);
                        visited[nextR][nextC] = false;
                    }
                }
            }
        }
    }
}
