import java.io.*;
import java.util.*;

public class 결혼식 {
    private static int n, m;
    private static boolean[] flag;
    private static int[][] graph;
    private static ArrayList<Integer> friends = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];  // 친구관계

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        flag = new boolean[n + 1];  // 친구 확인
        search(1);  // 친구찾기(상근이 친구)

        int friend1 = friends.size(); // 상근이 친구 수
        for(int j = 0; j < friend1; j ++) {
            search(friends.get(j)); // 친구의 친구 찾기
        }

        System.out.println(friends.size());
        br.close();
    }

    private static void search(int start) {
        for (int i = 2; i <= n; i++) {
            if (graph[start][i] == 1 && !flag[i]) {
                flag[i] = true;
                friends.add(i);
            }
            if (graph[i][start] == 1 && !flag[i]) {
                flag[i] = true;
                friends.add(i);
            }
        }
    }
}
