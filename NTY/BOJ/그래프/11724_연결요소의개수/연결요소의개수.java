//import java.io.*;
//import java.util.*;
//
//public class 연결요소의개수 {
//    private static int N;
//    private static int M;
//    private static int count_connect;
//    private static int[][] graph;
//    private static boolean[] flag;
//    private static Stack<Integer> stack = new Stack<>();
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer NM = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(NM.nextToken());
//        M = Integer.parseInt(NM.nextToken());
//
//        graph = new int[N][N];
//
//        for (int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken()) - 1;
//            int y = Integer.parseInt(st.nextToken()) - 1;
//            graph[x][y]++;
//            graph[y][x]++;
//        }
//
//        flag = new boolean[N];
//        count_connect = 0;
//
//        for (int i = 0; i < N; i++){
//            if(!flag[i]){
//                dfs(i);
//                count_connect++;
//            }
//        }
//
//        System.out.println(count_connect);
//    }
//
//    private static void dfs(int start) {
//        flag[start] = true;
//        for (int i = 0; i < N; i++) {
//            if(graph[start][i] == 1 && !flag[i]){
//                dfs(i);
//            }
//        }
//    }
//
//}


import java.io.*;
import java.util.*;

public class 연결요소의개수 {
    private static int N;
    private static int M;

    private static int count_connect;
    private static int[][] graph;
    private static boolean[] flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer NM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            graph[x][y]++;
            graph[y][x]++;
        }

        flag = new boolean[N];
        count_connect = 0;
        for (int i = 0; i < N; i++){
            if(!flag[i]){   // 방문하지 않은 곳
                dfs(i); // DFS로 연결 탐색
                count_connect++;    // 연결 카운트
            }
        }

        System.out.println(count_connect);
    }

    // DFS로 연결
    private static void dfs(int start) {
        flag[start] = true; // 방문 확인
        for (int i = 0; i < N; i++) {
            if(graph[start][i] == 1 && !flag[i]){
                dfs(i); // 재귀
            }
        }
    }

}