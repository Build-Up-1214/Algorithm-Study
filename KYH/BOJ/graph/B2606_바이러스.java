package baekjoon.graph_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 성공 **/
public class B2606_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int comCtn = Integer.parseInt(bf.readLine());
        int edgeCtn = Integer.parseInt(bf.readLine());

        int[][] edge = new int[comCtn+1][comCtn+1];
        for (int i = 0; i < edgeCtn; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edge[x][y] = 1;
            edge[y][x] = 1;
        }

        System.out.println(solution(edge));
    }

    public static int solution(int[][] edge) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[edge.length];
        int result = 0;

        queue.offer(1);

        while (!queue.isEmpty()) {

            Integer virusComputer = queue.poll();
            visited[virusComputer] = true;

            for (int i = 1; i < edge[virusComputer].length; i++) {

                if (edge[virusComputer][i] == 1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                    //최초에 감염되어 있는 1번 컴퓨터를 제외한,
                    //이후에 컴퓨터들을 감염 컴퓨터로써 횟수에 포함시켜야 하기 때문에 결과값을 이곳에서 증가시킨다.
                    result++;
                }
            }
        }

        return result;
    }
}
