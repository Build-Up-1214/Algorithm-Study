package baekjoon.backtracking_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** 성공 **/
public class C15649_N과M3 {

    static int n,m;
    static StringBuilder sb = new StringBuilder();
    static int[] intArr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        intArr = new int[m];

        recursion(0);

        System.out.println(sb);
    }

    private static void recursion(int depth) {

        if(depth == m)
        {
            for (int i = 0; i < m; i++) {
                sb.append(intArr[i] + " ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {

            intArr[depth] = i;
            recursion(depth+1);
        }

    }
}
