import java.io.*;
import java.util.*;

public class 순열사이클 {
    private static int N;
    private static int[] arr;
    private static boolean[] flag;
    private static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트 수

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());    // 정점 수
            arr = new int[N];   // 순열 담을 배열
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken()) - 1;
            }
            test(); // 테스트 실행
            sb.append(count).append("\n");  // 테스트 실행 후 사이클 개수 출력
        }
        br.close();
        System.out.print(sb);
    }

    private static void test() {
        flag = new boolean[arr.length]; // 순열에 방문 했는지 체크
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!flag[i]) {
                dfs(i); // DFS로 사이클 체크
                count++;    // 한 번의 DFS가 끝나면 사이클 1번 횟수 추가
            }
        }
    }

    private static void dfs(int start) {
        flag[start] = true;
        if(!flag[arr[start]]) dfs(arr[start]);
    }
}
