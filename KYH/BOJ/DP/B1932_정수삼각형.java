package baekjoon.dp_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] level = new int[n][n];
        int[][] sum = new int[n][n];


        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j <= i; j++) {
                int value = Integer.parseInt(st.nextToken());
                level[i][j] = value;
            }
        }

        sum[0][0] = level[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int a = 0;
                int b = 0;

                if ((j - 1) >= 0) {
                    a = sum[i-1][j-1] + level[i][j];
                }

                if (j <= i-1) {
                    b = sum[i-1][j] + level[i][j];
                }

                sum[i][j] = Math.max(a,b);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max < sum[n-1][i])
                max = sum[n-1][i];
        }

        System.out.println(max);


        //level[][] 배열 선언
        //sum[][] 배열 선언
        //sum[0][0] = level[0][0];

        //반복문 시작. i = 1 ~ n
        //  반복문 시작. j = 0 ~ j
        //      int a = 0;
        //      int b = 0;
        //          if((j-1) >= 0)
        //              a = sum[i-1][j-1]
        //          if(j <= i)
        //              b = sum[i-1][j];
        //      sum[i][j] = Math.max(a,b);
        //
        //  ~반복문 시작
        //~반복문 시작


    }
}
