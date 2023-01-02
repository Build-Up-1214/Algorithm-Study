import java.io.*;
import java.util.*;

public class DFS와BFS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer NMV = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(NMV.nextToken());  // 정점
        int M = Integer.parseInt(NMV.nextToken());  // 간선
        int V = Integer.parseInt(NMV.nextToken());  // 시작 정점

        int[][] graph = new int[N][N];  // 그래프

        // 그래프에 연결관계 저장(정점과 간선)
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            graph[x][y]++;
            graph[y][x]++;
        }

        // DFS
        Stack<Integer> stack = new Stack<>();   // 스택으로 구현
        boolean[] flag = new boolean[N];    // 정점을 탐색했는지 유무 표현
        stack.push(V-1);
        while(!stack.empty()) {
            int pop = stack.pop();
            if(!flag[pop]){
                flag[pop] = true;
                sb.append(pop + 1).append(" ");
            }
            for (int i = N - 1; i >= 0; i--) {  // 후입 선출 -> N -1 부터 시작
                if (graph[pop][i] != 0 && !flag[i]) {
                    stack.push(i);
                }
            }

        }

        sb.append("\n");

        // BFS
        Queue<Integer> queue = new LinkedList<>();  // 큐로 구현
        flag = new boolean[N]; // 정점을 탐색했는지 유무 표현
        queue.offer(V-1);
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            if(!flag[poll]){
                flag[poll] = true;
                sb.append(poll + 1).append(" ");
            }
            for (int i = 0; i < N; i++) {
                if (graph[poll][i] != 0 && !flag[i]) {
                    queue.offer(i);
                }
            }
        }

        System.out.println(sb);
    }
}