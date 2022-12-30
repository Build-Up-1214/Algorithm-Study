import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = chars[j] - '0';
            }
        }
        visited = new boolean[N][M];
        visited[0][0] = true;
        bfs(0,0);
        System.out.println(maze[N-1][M-1]);

    }
    // 최단거리 - bfs 이용
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M
                        || visited[nextX][nextY] || maze[nextX][nextY] == 0) continue;
                maze[nextX][nextY] = maze[curX][curY] + 1;
                visited[nextX][nextY] = true;
                queue.offer(new int[] {nextX, nextY});
            }
        }
    }
}