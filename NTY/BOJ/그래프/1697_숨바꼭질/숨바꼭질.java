import java.io.*;
import java.util.*;

public class 숨바꼭질 {
    private static int N, K;
    private static int[] location = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {   // N이 K보다 크거나 작은경우 -> 뒤로가는거만 가능하기 때문에 -1 반복
            location[K] = N - K + 1 ;   // +1 은 임시로 시작 초가 0이 아니라 1로 계산햇기 때문
        }
        else bfs();

        bw.write(String.valueOf(location[K] - 1));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() { // BFS로 계산
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);
        location[N] = 1;    // 시작 초를 1로 계산 -> 0을 안한걸로 판단하기 위해

        while (!queue.isEmpty()) {
            if (location[K] != 0) return;   // K에 도달 했으면 루프 빠져나옴 -> 최소값
            int n = queue.poll();
            if (n - 1 >= 0 && location[n - 1] == 0) {   // X -1
                location[n - 1] = location[n] + 1;
                queue.offer(n - 1);
            }
            if (n + 1 <= 100000 && location[n + 1] == 0) {  // X + 1
                location[n + 1] = location[n] + 1;
                queue.offer(n + 1);
            }
            if (2 * n <= 100000 && location[2 * n] == 0) {  // 2 * X
                location[2 * n] = location[n] + 1;
                queue.offer(2 * n);
            }
        }
    }
}