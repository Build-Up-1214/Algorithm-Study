package baekjoon.graph_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 성공 **/
public class B1697_숨바꼭질 {

    private static int n;
    private static int k;
    private static int[] map = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(map[k]);
    }

    static void bfs() {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

            if (poll.equals(k)) {
                break;
            }

            if (poll - 1 >= 0 && map[poll - 1] == 0) {
                queue.offer(poll-1);
                map[poll-1] = map[poll] + 1;
            }

            if (poll + 1 <= 100000 && map[poll + 1] == 0) {
                queue.offer(poll+1);
                map[poll+1] = map[poll] + 1;
            }

            if (poll * 2 <= 100000 && map[poll * 2] == 0) {
                queue.offer(poll*2);
                map[poll * 2] = map[poll] + 1;
            }
        }
    }
}
