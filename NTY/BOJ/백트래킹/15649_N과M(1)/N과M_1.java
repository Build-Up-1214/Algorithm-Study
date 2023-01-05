import java.io.*;
import java.util.*;

public class N과M_1 {
    static int N, M;
    static int[] arr;
    static boolean[] flag;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        flag = new boolean[N];

        recursion(0);

        System.out.println(sb);
    }

    private static void recursion(int R){
        // 정해진 재귀 깊이(배열 길이 만큼)이면 배열 출력
        if (R == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!flag[j]) { // 방문하지 않은, 사용하지 않은 숫자이면
                arr[R] = j + 1; // 해당 자리 숫자 저장
                flag[j] = true; // 사용한 상태로 변경
                recursion(R + 1);   // 다음 자리 숫자 채우기 위해 재귀
                flag[j] = false;    // 다음자리 재귀 끝나고 돌아오면 방문하지 않으 상태로 변경 -> 다음 케이스 위해
            }
        }
    }
}