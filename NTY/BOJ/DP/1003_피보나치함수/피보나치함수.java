import java.io.*;

public class 피보나치함수 {
    static int[][] dp = new int[41][2];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[0][0] = dp[1][1] = 1;
        dp[0][1] = dp[1][0] = 0;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    static int[] fibonacci(int N) {
        if(N > 1) {
            if(dp[N][0] == 0 || dp[N][1] == 0) {
                dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
                dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
            }
        }
        return dp[N];
    }
}