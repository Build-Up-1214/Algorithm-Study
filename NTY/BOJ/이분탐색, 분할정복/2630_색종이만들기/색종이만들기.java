import java.io.*;
import java.util.*;

public class 색종이만들기 {
    private static int blue, white;
    private static int[][] square;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        square = new int[N][N];

        blue = white = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        separate(0, 0, N);

        sb.append(white).append("\n").append(blue);

        System.out.println(sb);
        br.close();
    }

    // 체크 후 분할
    private static void separate(int x, int y, int n) {
        if(isAll(x, y, n)){
            if(square[x][y] == 1) blue++;
            else white++;
        }
        else{   // 사분면으로 나눠 0, x증가, y증가, x와 y증가를 사이즈가 반인 경우로 재귀 호출
            separate(x, y, n / 2);
            separate(x + n / 2, y, n / 2);
            separate(x, y + n / 2, n / 2);
            separate(x + n / 2, y + n / 2, n / 2);
        }
    }

    // 부분 사각형이 전부 흰색 or 파란색인지 체크 하는 함수
    private static boolean isAll(int x, int y, int n) {
        boolean result = true;
        loop:
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(square[i][j] != square[x][y]) {
                    result = false;
                    break loop;
                }
            }
        }
        return result;
    }
}
