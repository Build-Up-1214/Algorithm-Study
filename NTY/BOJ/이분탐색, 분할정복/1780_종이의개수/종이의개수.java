import java.io.*;
import java.util.*;

public class 종이의개수 {
    private static int a, b, c; // -1, 0, 1 개수
    private static int[][] paper;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);

        sb.append(a).append("\n").append(b).append("\n").append(c);
        System.out.println(sb);
        br.close();
    }
    // 분할
    private static void cut(int x, int y, int n) {
        if (!check(x, y, n)) {
            for(int i = x; i < x + n; i += n / 3){
                for (int j = y; j < y + n; j += n /3) {
                    cut(i, j, n / 3);
                }
            }
        }
    }
    // 분할된 부분이 같은 숫자로 구성되어 있는지 체크
    private static boolean check(int x, int y, int n) {
        int compare = paper[x][y];
        for(int i = x; i < x + n; i++){
            for (int j = y; j < y + n; j++) {
                if(paper[i][j] != compare) return false;
            }
        }
        if(compare == -1) a++;
        else if(compare == 0) b++;
        else c++;
        return true;
    }
}
