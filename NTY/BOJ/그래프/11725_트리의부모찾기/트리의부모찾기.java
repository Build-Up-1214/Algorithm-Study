import java.io.*;
import java.util.*;

public class 트리의부모찾기 {
    /*
    인접행렬 -> 인접리스트
    문제 트리 구조는 이진 트리가 아니다!! 그런말없다..
    이 문제는 bfs ,dfs 중 bfs 가 조금더 빠른거같다
     */
    private static int N;
    private static int[] parentNode;
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();    // 인접리스트(인접행렬로 진행하면 런타임에러 발생)

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {   // 인접리스트 생성
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        parentNode = new int[N + 1];    // 각 노드(인덱스) 마다 부모노드 저장

        bfs(1);     // bfs

        for (int j = 2; j <= N; j++) {  // 출력
            sb.append(parentNode[j]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int root) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(root);
        parentNode[root] = root;

        while(!queue.isEmpty()) {
            int parent = queue.poll();
            for(int child : list.get(parent)) {
                if (parentNode[child] == 0) {
                    parentNode[child] = parent;
                    queue.offer(child);
                }
            }
        }
    }
}