import java.io.*;
import java.util.*;

public class 오목 {
    private static int wx = 0, wy = 0, winner = 0;
    private static int[][] board = new int[19][19];
    private static boolean[][][] isSearch = new boolean[19][19][4]; // 바둑판 한 자리에서 4방향 체크 기록
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        findWinner();

        sb.append(winner);
        if(winner != 0) sb.append('\n').append(wx + 1).append(' ').append(wy + 1);

        System.out.println(sb);
    }

    private static void findWinner() {
        loop:   // 오목 발견하면 가장 왼쪽 -> 가장 윗쪽 위치 찾기 위해 for 문 순회 설정
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if(board[j][i] != 0){
                    if(!isSearch[j][i][0] && j + 4 < 19) column(j, i, 1);   // 세로
                    if(winner != 0) break loop; // 각 방향 탐색 후 오목 되면 종료
                    if(!isSearch[j][i][1] && i + 4 < 19) row(j, i, 1);  // 가로
                    if(winner != 0) break loop;
                    if(!isSearch[j][i][2] && j + 4 < 19 && i + 4 < 19) diagonal1(j, i, 1);  // 대각선(상승)
                    if(winner != 0) break loop;
                    if(!isSearch[j][i][3] && j - 4 >= 0 && i + 4 < 19) diagonal2(j, i, 1);  // 대각선(하강)
                    if(winner != 0) break loop;
                }
            }
        }
    }

    private static void column(int x, int y, int d){
        isSearch[x][y][0] = true;   // 방향 탐색 체크
        if(d == 5) {
            if(x + 1 < 19 && board[x][y] == board[x + 1][y]) isSearch[x + 1][y][0] = true;  // 6개 연결되면 체크만하고 종료
            else winner = board[x][y]; wx = x - 4; wy = y;  // 5개만 저장
        } else if(board[x][y] == board[x + 1][y]) column(x + 1, y, d + 1);
    }

    private static void row(int x, int y, int d){
        isSearch[x][y][1] = true;
        if(d == 5) {
            if(y + 1 < 19 && board[x][y] == board[x][y + 1]) isSearch[x][y + 1][1] = true;
            else winner = board[x][y]; wx = x; wy = y - 4;
        } else if(board[x][y] == board[x][y + 1]) row(x, y + 1, d + 1);
    }

    private static void diagonal1(int x, int y, int d){ // 대각선 상승
        isSearch[x][y][2] = true;
        if(d == 5) {
            if(x + 1 < 19 && y + 1 < 19 && board[x][y] == board[x + 1][y + 1]) isSearch[x + 1][y + 1][2] = true;
            else winner = board[x][y]; wx = x - 4; wy = y - 4;
        } else if(board[x][y] == board[x + 1][y + 1]) diagonal1(x + 1, y + 1, d + 1);
    }

    private static void diagonal2(int x, int y, int d){ // 대각선 하강
        isSearch[x][y][3] = true;
        if(d == 5) {
            if(x - 1 >= 0 && y + 1 < 19 && board[x][y] == board[x - 1][y + 1]) isSearch[x - 1][y + 1][3] = true;
            else winner = board[x][y]; wx = x + 4; wy = y - 4;
        } else if(board[x][y] == board[x - 1][y + 1]) diagonal2(x - 1, y + 1, d + 1);
    }
}