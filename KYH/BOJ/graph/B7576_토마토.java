package baekjoon.graph_그래프.bfs_넓이우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공 **/
public class B7576_토마토2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(st.nextToken());

                map[i][j] = tomato;
                if (tomato == 1) {
                    //1인 요소를 queue에 찾으려 map을 전체 조회하는 것을 줄이기 위해 즉시 queue에 넣음
                    queue.offer(new Integer[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        System.out.println(solution(map, queue, visited));
    }

    public static int solution(int[][] map, Queue<Integer[]> queue, boolean[][] visited) {

        int day = bfs(map, queue, visited);

        //배열의 값 중 0이 존재하는지, 익을 수 없는 토마토 존재 상황
        if (Arrays.stream(map).anyMatch(arr-> Arrays.stream(arr).anyMatch(i-> i == 0))) {
            return -1;
        }
        else {
            return day;
        }
    }

    public static int bfs(int[][] map, Queue<Integer[]> ripeningTomatoQueue, boolean[][] visited) {
        int day = 0;

        //하루가 지나고 자동으로 익게 되는 토마토들의 좌표를 저장하기 위한 리스트
        List<Integer[]> nextTomato = new ArrayList<>();

        //큐에 있는 토마토들의 방문처리와 주변 토마토 조사를 마치고 큐에 새롭게 넣은 다음, 다음에 익을 토마토들을 처리 하기 위한 상위 반복문
        while (true) {
            while (!ripeningTomatoQueue.isEmpty()) {

                Integer[] tomatoPosition = ripeningTomatoQueue.poll();
                int row = tomatoPosition[0];
                int col = tomatoPosition[1];
                map[row][col] = 1; //다음에 익는 토마트들의 익은 처리


                //상
                if (0 <= row - 1 && map[row - 1][col] == 0 && visited[row - 1][col] == false) {
                    nextTomato.add(new Integer[]{row-1, col});

                    //추후 처리 될 토마토가 중복으로 담기는 것을 방지 하기 위해, 즉시 방문처리
                    //이 순간 방문 처리를 하지 않으면, 다음에 익을 토마토들이 중복으로 담겨서 메모리초과 발생!
                    visited[row-1][col] = true;
                }
                //하
                if (map.length-1 >= row + 1 && map[row + 1][col] == 0 && visited[row + 1][col] == false) {
                    nextTomato.add(new Integer[]{row + 1, col});
                    visited[row+1][col] = true;
                }
                //좌
                if (0 <= col - 1 && map[row][col - 1] == 0 && visited[row][col - 1] == false) {
                    nextTomato.add(new Integer[]{row, col - 1});
                    visited[row][col-1] = true;
                }
                //우
                if (map[0].length-1 >= col + 1 && map[row][col + 1] == 0 && visited[row][col + 1] == false) {
                    nextTomato.add(new Integer[]{row, col + 1});
                    visited[row][col+1] = true;
                }
            }

            if (nextTomato.size() != 0) {

                //큐에 담긴것들을 먼저 처리 한후, 이후에 day를 증가시켜야한다.
                //그렇지 않으면, 애초에 모두 1인 map이 input으로 들어 왔을때, 결과가 0이여야 함에도 1로써 리턴된다
                day++;
                ripeningTomatoQueue = new LinkedList<>(nextTomato); //다음 날에 처리 될 토마토를 queue에 담음
                nextTomato.clear();
            }
            else {
                break;
            }
        }

        return day;
    }

}
