package baekjoon.tree_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공 **/
public class B11725_트리의부모찾기 {
    public static void main(String[] args) throws IOException {

        int n;
        int[] parent;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited;
        Map<Integer,List<Integer>> edge = new HashMap();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        visited = new boolean[n+1];
        parent = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            edge.put(i, new ArrayList<>());
        }

        StringTokenizer st;

        for (int i = 0; i < n - 1; i++) {

            st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge.get(a).add(b);
            edge.get(b).add(a);
        }

        queue.offer(1);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            List<Integer> list = edge.get(node);

            for (Integer integer : list) {
                if(visited[integer])
                    continue;
                parent[integer] = node;
                queue.offer(integer);
            }

            visited[node] = true;

        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }

    }
}
