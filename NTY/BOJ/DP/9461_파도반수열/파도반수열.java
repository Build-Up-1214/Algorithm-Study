import java.io.*;

public class 파도반수열 {
    private static long[] dp;   // N이 크면 int범위 벗어남..
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        //초기값
        dp = new long[100 + 1];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            if(N > 5) {
                for (int i = 6; i <= N; i++) {
                    dp[i] = dp[i - 1] + dp[i - 5];  // 배열 규칙
                }
            }
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}