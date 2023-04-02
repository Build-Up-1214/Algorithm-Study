import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            int min = 5;
            for (int j = 1; j * j <= i; j++) {
                int t = i - j * j;
                min = Math.min(min, dp[t]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[N]);
    }
}
