package baekjoon.graph_그래프.dfs_깊이우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B1520_내리막길 {

    //dp를 사용하여 방문했던 경로를 생략하지 않으면 시간 초과가 발생하는 문제
    static int m, n;
    static int[][] dp;
    static int[][] map;
    static int[] dc = {0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine(), " ");

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }


        dfs(0,0);
        System.out.println(dp[0][0]);

    }

    private static int dfs(int curR, int curC) {

        if (curR == (m - 1) && curC == (n - 1)) {
            return 1;
        }

        if (dp[curR][curC] != -1) {
            //-1이 아닌 경우는 이미 방문했다(메모이제이션)
            return dp[curR][curC];
        }

        dp[curR][curC] = 0;

        for (int i = 0; i < 4; i++) {

            int nextR = curR + dr[i];
            int nextC = curC + dc[i];

            if (nextR >= 0 && nextR <= (m - 1) && nextC >= 0 && nextC <= (n - 1)) {
                if (map[nextR][nextC] < map[curR][curC]) {

                    dp[curR][curC] += dfs(nextR,nextC);
                }
            }
        }
        return dp[curR][curC];
    }
}

//초기 수도코드
//dfs(현재 r, 현재 c)
//  만약(현재 r과 c가 도착 r,c와 같다면)
//      결과 변수 + 1
//      리턴
//
//  반복문(i = 1 ~ 4; i++)
//      다음 R
//      다음 C
//      다음 R C 가 조건에 맞는다면
//      visited[다음R][다음C] = true
//      dfs() 재귀
//      visited[다음R][다음C] = false
//  ~반복문 종료