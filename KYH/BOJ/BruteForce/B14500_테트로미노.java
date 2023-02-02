package baekjoon.brute_force_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B14500_테트로미노 {

    static int[][] map;
    static int max = 0;
    static boolean[][] checked;
    static int[] dx = new int[]{0,0,-1,1}; //상하좌우시 x(column) 변화량
    static int[] dy = new int[]{-1,1,0,0}; //상하좌우시 y(row) 변화량
    static int n, m;
    static int[][][] specialPosition = { //ㅗ,ㅜ,ㅓ,ㅏ 순서대로 중심 좌표 기준으로 각 점마다의 row, col 좌표 변화량
            {{-1,0},{0,-1},{0,1}},
            {{0,-1},{1,0},{0,1}},
            {{0,-1},{-1,0},{1,0}},
            {{0,1},{-1,0},{1,0}}
    }; //ㅏ,ㅓ,ㅗ,ㅜ 도형의 상하좌우의 변화량

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];
        checked = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checked[i][j] = true;
                dfs(i, j, 0, map[i][j]);
                checked[i][j] = false;
                special(i, j);
            }
        }

        System.out.println(max);
    }

    //ㅓ를 제외한 도형, dfs로 4(0~3)단계까지 거치면 모든 모양이 ㅓ를 제외한 테트로미노 모양이 됨.
    //그러므로 그냥 dfs를 4단계 까지만 돌리고 4단계 까지의 모든 좌표의 값들만 더해주면 됨
    static void dfs(int row, int col, int depth, int sum) {

        if (depth == 3) {
            if (sum > max) {
                max = sum;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {

            int nCol = col + dx[i];
            int nRow = row + dy[i];

            if (nCol >= 0 && nRow >= 0 && nCol < m && nRow < n) {
                if (!checked[nRow][nCol]) {
                    checked[nRow][nCol] = true;
                    dfs(nRow, nCol, depth+1, sum+map[nRow][nCol]);
                    checked[nRow][nCol] = false;
                }

            }
        }
    }

    //ㅗ,ㅜ,ㅓ,ㅏ는 그냥 dfs로는 구할 수가 없음
    //그러므로, 따로 구현해야 한다.
    //참고로 중심 좌표 기준으로 위,아래,좌,우로만 뻗어나간 경우만 체크하면 됨
    //시작좌표가 ㅗ,ㅜ,ㅓ,ㅏ에서 끝에 있는 것일 경우에는 어차피 다른 좌표에서 중심좌표 해당 모양을 체크하므로 할 필요 없음
    static void special(int row, int col) {

        for (int[][] positions : specialPosition) {
            boolean check = true;

            int sum = map[row][col];
            for (int[] pos : positions) {

                int newRow = row + pos[0];
                int newCol = col + pos[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    sum += map[newRow][newCol];
                }
                else {
                    check = false;
                    break;
                }
            }

            if (check) {
                if(sum > max)
                    max = sum;
            }

        }
    }
}