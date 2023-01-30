import java.util.*;
import java.io.*;

public class 도영이가만든맛있는음식 {
    private static int N, min = 1000000000;
    private static int[][] ingredient;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ingredient = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 1 << N; i++) {  // 재료 부분선택
            check(i);
            if(min == 0) break;
        }

        System.out.println(min);
    }

    // 선택한 요리의 신맛과 쓴맛 차이 최소 체크
    private static void check(int n) {
        int S = 1, B = 0;
        for (int i = 0; i < N; i++) {
            if((n & 1 << i) > 0){
                S *= ingredient[i][0];
                B += ingredient[i][1];
                if(S >= 1000000000 || B >= 1000000000) return;
            }
        }
        min = Math.min(Math.abs(S - B), min);
    }
}