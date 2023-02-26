import java.util.*;
import java.io.*;

public class 적록색약 {
    private static int N, red, green, blue;
    private static boolean[][] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Character[][] graphA = new Character[N][N]; // 적록색약 X
        Character[][] graphB = new Character[N][N]; // 적록색약 O
        check = new boolean[N][N];
        red = green = blue = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                graphA[i][j] = c;
                graphB[i][j] = c == 'G' ? 'R' : c;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!check[i][j]) bfs(graphA, i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(red + green + blue).append(' ');

        red = blue = 0;
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!check[i][j]) bfs(graphB, i, j);
            }
        }

        sb.append(red + blue);
        System.out.println(sb);
    }

    private static void bfs(Character[][] graph, int a, int b) {
        if(graph[a][b] == 'R') red++;
        else if(graph[a][b] == 'B') blue++;
        else green++;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, b));
        check[a][b] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            if(x+1 < N && !check[x+1][y] && graph[x+1][y].equals(graph[a][b])) {
                q.add(new Node(x+1, y));
                check[x+1][y] = true;
            }
            if(x-1 >= 0 && !check[x-1][y] && graph[x-1][y].equals(graph[a][b])) {
                q.add(new Node(x-1, y));
                check[x-1][y] = true;
            }
            if(y+1 < N && !check[x][y+1] && graph[x][y+1].equals(graph[a][b])) {
                q.add(new Node(x, y+1));
                check[x][y+1] = true;
            }
            if(y-1 >= 0 && !check[x][y-1] && graph[x][y-1].equals(graph[a][b])) {
                q.add(new Node(x, y-1));
                check[x][y-1] = true;
            }
        }
    }

    private static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
    }
}