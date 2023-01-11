package baekjoon.dp_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 성공 **/
public class B2775_부녀회장이될테야 {

    static int[][] arr = new int[15][15];

    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= 14; i++) {
            arr[0][i] = i;
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        int[] result = new int[t];
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            result[i] = dp(k,n);
        }

        Arrays.stream(result).forEach(i-> System.out.println(i));
    }

    private static int dp(int k, int n) {

        if(arr[k][n] != 0)
            return arr[k][n];

        for (int i = 1; i <= n; i++) {
            arr[k][n] += dp(k-1, i);
        }

        return arr[k][n];
    }
}
