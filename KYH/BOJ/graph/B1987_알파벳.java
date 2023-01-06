package baekjoon.graph_그래프.dfs_깊이우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B1987_알파벳 {

    //해당 문제는 stack을 이용하여 풀 수 도 있지만,
    //그럴 경우 stack 내부적인 자료구조로 인해 시간초과가 발생 함
    //그로 인해 alphabet boolea배열을 이용하여 체크만으로 현재까지의 문자열 포함 상태를 체크한다.

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0, -1, 1};
    static char[][] map;
    static int r,c;
    static int maxCtn;
    static boolean[] alphabet = new boolean[26]; //알파벳의 최대 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r+1][c+1];


        for (int i = 1; i <= r; i++) {

            String line = bf.readLine();
            for (int j = 1; j <= c; j++) {
                char ch = line.charAt(j-1);
                map[i][j] = ch;

            }
        }
        alphabet[map[1][1]-'A'] = true;
        dfs(1,1, 1);
        System.out.println(maxCtn);
    }

    static void dfs(int curR, int curC, int count) {

        boolean stop = false;

        for (int i = 0; i < 4; i++) {

            int nextR = curR+dr[i];
            int nextC = curC+dc[i];

            if (nextR >= 1 && nextR <= r && nextC >= 1 && nextC <= c) {
                if (!alphabet[map[nextR][nextC] - 'A']) {

                    alphabet[map[nextR][nextC] - 'A'] = true; //탐색 경로에 포함 된 경우 true 체크
                    dfs(nextR, nextC, count + 1);
                    alphabet[map[nextR][nextC] - 'A'] = false; //탐색 경로에 빠져 나온 경우 false로 전환
                }
            }
        }

        if (maxCtn < count) {
            maxCtn = count;

        }

    }
}
