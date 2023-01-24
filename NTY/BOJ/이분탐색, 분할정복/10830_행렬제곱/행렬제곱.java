import java.util.*;
import java.io.*;

public class 행렬제곱 {
    private static int N;
    private static int[][] input;
    private final static int MOD = 1000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());  //  1 ≤ B ≤ 100,000,000,000

        input = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) input[i][j] = Integer.parseInt(st.nextToken()) % MOD;   // B = 1일때 고려
        }

        int[][] result = f(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) sb.append(result[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
    private static int[][] f(long n) {
        if(n == 1L) return input;
        int[][] result = f(n / 2);  // 변수 선언해서 재사
        result = multi(result, result);
        if(n % 2 == 1L) result = multi(result, input);
        return result;
    }

    private static int[][] multi(int[][] arr1, int[][] arr2) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}