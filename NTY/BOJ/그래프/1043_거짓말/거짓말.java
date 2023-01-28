import java.io.*;
import java.util.*;

public class 거짓말 {
    private static int N, M, max;
    private static boolean[][] graph;   // 파티와 파티원 담을 배열
    private static Queue<Integer> q = new LinkedList<>();   // 진실 아는 사람 담을 큐
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = max = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) q.offer(Integer.parseInt(st.nextToken()));

        graph = new boolean[M][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) graph[i][Integer.parseInt(st.nextToken())] = true;
        }

        if(k != 0) bfs();   // 진실아는 사림이 있을 경우만, 없으면 M

        System.out.println(max);
    }

    private static void bfs() {
        boolean[] checkParty = new boolean[M];   // 이야기 할 수 없는 파티 체크
        boolean[] checkPerson = new boolean[N + 1]; // 진실 아는사람
        while (!q.isEmpty()) {
            int x = q.poll();
            checkPerson[x] = true;
            for (int i = 0; i < M; i++) {
                if(!checkParty[i] && graph[i][x]) {  // 이야기 할 수 있는 파티 중 진실 아는사람이 있으면
                    checkParty[i] = true;
                    for (int j = 1; j <= N; j++) if(!checkPerson[j] && graph[i][j]) q.offer(j);    // 진실 아는사람과 같이있던사람 큐에 담기
                    max--;
                }
            }
        }
    }
}