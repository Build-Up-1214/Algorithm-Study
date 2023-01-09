import java.util.*;
import java.io.*;

public class 섬의개수 {
    private static int w, h;
    private static int[][] arr;
    private static int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) { // 테스트 케이스 루프
            StringTokenizer wh = new StringTokenizer(br.readLine());
            w = Integer.parseInt(wh.nextToken());
            h = Integer.parseInt(wh.nextToken());

            if (w == 0 && h == 0) break;    // 0 0 들어오면 루프 종료

            arr = new int[h][w];    // w, h 크기 배열 생성(초기화)

            // 테스트 케이스 배열에 저장
            for (int i = 0; i < h; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;  // 섬 개수 선언 및 초기화

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(arr[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int y, int x) {
        arr[y][x] = 0;
        for (int i = 0; i < 8; i++) {   // 가로, 세로, 대각선 증가 좌표 대입
            if(y + dy[i] < h && y + dy[i] >= 0 && x + dx[i] >= 0 && x + dx[i] < w){
                if(arr[y + dy[i]][x + dx[i]] == 1) dfs(y + dy[i], x + dx[i]);
            }
        }
    }
}