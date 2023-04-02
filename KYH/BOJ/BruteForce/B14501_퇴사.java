package baekjoon.brute_force_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 제출 **/
public class B14501_퇴사 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] DP = new int[N+2];

        for (int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) DP[i] = DP[i+1];
            else {
                DP[i] = Math.max(DP[i+1], P[i] + DP[i+T[i]]);
            }
        }
        System.out.println(DP[1]);

    }
}
