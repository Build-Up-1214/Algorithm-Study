package baekjoon.graph_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** 성공, (dfs, 재귀 사용) **/
public class B4963_섬의개수 {

    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int h,w;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> result = new ArrayList<>();

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < w; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[i][j] = value;
                }
            }

            int ctn = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i,j);
                        ctn++;
                    }
                }
            }
            result.add(ctn);

        }

        for (int ctn : result) {
            System.out.println(ctn);
        }
    }

    static void dfs(int curH, int curW) {

        for (int i = 0; i < 8; i++) {

            int tempH = curH + dy[i];
            int tempW = curW + dx[i];

            if (tempH >= 0 && tempH < h && tempW >= 0 && tempW < w) {
                if (map[tempH][tempW] == 1 && !visited[tempH][tempW]) {
                    visited[tempH][tempW] = true;
                    dfs(tempH, tempW);
                }
            }
        }
    }
}
