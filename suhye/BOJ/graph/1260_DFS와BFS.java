import java.util.*;
import java.io.*;

public class Main {
    static int N,M,V;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(V);
        sb.append("\n");
        visit = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int id) {
        visit[id] = true;
		sb.append(id + " ");
		for(int i = 1; i <= N; i++) {
			if(arr[id][i] == 1 && visit[i] == false) {
                dfs(i);
            }
		}
    }

    public static void bfs(int id) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        visit[id] = true;
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            sb.append(curId + " ");
            for (int i = 1; i <= N; i++) {
                if (arr[curId][i] == 1 && visit[i] == false) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}