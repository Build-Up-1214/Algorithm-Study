import java.io.*;
import java.util.*;

public class 미로탐색 {
    private static int N ,M, step;
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    private static int[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer NM = new StringTokenizer(br.readLine());

        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
        step = 0;
        bfs();
        System.out.println(step);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1));
        graph[0][0] = 0;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.getX();
            int y = point.getY();
            if (x == N - 1 && y == M - 1) {
                step = point.getDepth();
                break;
            }
            for (int i = 0; i < 4; i++) {
                if (x + dx[i] < N && x + dx[i] >= 0 && y + dy[i] < M && y + dy[i] >= 0) {
                    if (graph[x + dx[i]][y + dy[i]] == 1) {
                        queue.offer(new Point(x + dx[i], y + dy[i], point.getDepth() + 1));
                        graph[x + dx[i]][y + dy[i]] = 0;
                    }
                }
            }
        }
    }

    private static class Point{
        private int x;
        private int y;
        private int depth;

        private Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        private int getX() {
            return this.x;
        }

        private int getY() {
            return this.y;
        }

        private int getDepth() {
            return this.depth;
        }
    }
}