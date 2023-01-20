package baekjoon.dp_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B1149_RGB거리 {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] DP = new int[N+1][3];

        StringTokenizer st;
        for(int i=1;i<=N;i++) {

            st = new StringTokenizer(bf.readLine());


            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + R;
            DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + G;
            DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + B;
        }

        System.out.println(Math.min(DP[N][0], Math.min(DP[N][1], DP[N][2])));

    }

}
