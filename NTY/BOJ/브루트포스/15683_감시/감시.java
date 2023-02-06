import java.util.*;
import java.io.*;

public class 감시 {
    private static ArrayList<int[]> cctv = new ArrayList<>();
    private static int N, M, min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = N * M;
        int[][] office = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                // cctv(1~5)이면 리스트에 저장
                if(office[i][j] != 0 && office[i][j] != 6) cctv.add(new int[]{office[i][j], i, j});
            }
        }

        check(office, 0);
        System.out.println(min);
    }
    // 리스트에 저장된 cctv 체크
    private static void check(int[][] arr, int index) {
        if(index == cctv.size()) count(arr);
        else{
            int cctvCase = cctv.get(index)[0];  // cctv 종류 (1~4)
            int x = cctv.get(index)[1]; // 좌표
            int y = cctv.get(index)[2];
            int office[][] = new int[N][M]; // 각 케이스 마다 초기화 할 배열
            copy(arr, office);
            switch (cctvCase) { // cctv 케이스마다 방향 고려 dfs
                case 1 :
                    check(search(office, x, y, 1), index + 1);
                    copy(arr, office);
                    check(search(office, x, y, 2), index + 1);
                    copy(arr, office);
                    check(search(office, x, y, 3), index + 1);
                    copy(arr, office);
                    check(search(office, x, y, 4), index + 1);
                    break;
                case 2 :
                    check(search(search(office, x, y, 1), x, y, 3), index + 1);
                    copy(arr, office);
                    check(search(search(office, x, y, 2), x, y, 4), index + 1);
                    break;
                case 3 :
                    check(search(search(office, x, y, 1), x, y, 4), index + 1);
                    copy(arr, office);
                    check(search(search(office, x, y, 1), x, y, 2), index + 1);
                    copy(arr, office);
                    check(search(search(office, x, y, 2), x, y, 3), index + 1);
                    copy(arr, office);
                    check(search(search(office, x, y, 3), x, y, 4), index + 1);
                    break;
                case 4 :
                    check(search(search(search(office, x, y, 1), x, y, 3), x, y, 4), index + 1);
                    copy(arr, office);
                    check(search(search(search(office, x, y, 1), x, y, 2), x, y, 4), index + 1);
                    copy(arr, office);
                    check(search(search(search(office, x, y, 1), x, y, 2), x, y, 3), index + 1);
                    copy(arr, office);
                    check(search(search(search(office, x, y, 2), x, y, 3), x, y, 4), index + 1);
                    break;
                case 5 :
                    check(search(search(search(search(office, x, y, 1), x, y, 2), x, y, 3), x, y, 4), index + 1);
                    break;
            }
        }
    }
    // 방향에 따라 감시되는 곳(0 -> -1) 체크
    private static int[][] search(int[][] office, int x, int y, int direction) {
        switch (direction) {
            case 1 :
                for (int i = y; i < M; i++) {
                    if(office[x][i] == 6) break;
                    if(office[x][i] == 0) office[x][i] = -1;
                }
                break;
            case 2 :
                for (int i = x; i < N; i++) {
                    if(office[i][y] == 6) break;
                    if(office[i][y] == 0) office[i][y] = -1;
                }
                break;
            case 3 :
                for (int i = y; i >= 0; i--) {
                    if(office[x][i] == 6) break;
                    if(office[x][i] == 0) office[x][i] = -1;
                }
                break;
            case 4 :
                for (int i = x; i >= 0; i--) {
                    if(office[i][y] == 6) break;
                    if(office[i][y] == 0) office[i][y] = -1;
                }
                break;
        }
        return office;
    }
    // 0인곳(사각지대) 체크
    private static void count(int[][] office){
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(office[i][j] == 0) count++;
            }
        }
        min = Math.min(count, min);
    }
    // 배열 깊은 복사
    private static void copy(int[][] a, int[][] b) {
        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(a[i], 0, b[i], 0, M);
        }
    }
}