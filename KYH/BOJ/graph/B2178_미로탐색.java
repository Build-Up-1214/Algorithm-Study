package baekjoon.graph_그래프.bfs_넓이우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/** 성공 **/
public class B2178_미로탐색2 {

    static int n,m;
    static int[] dx = {0, 0, -1, 1}; //상하좌우시 x 좌표 값
    static int[] dy = {-1, 1, 0, 0}; //상하좌우시 y 좌표 값
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sp = bf.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);

        map = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String[] split = bf.readLine().split("");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(split[j-1]);
            }
        }

        int[][] counting = new int[n+1][m+1];
        counting[1][1] = 1;


        Queue<Integer[]> positionQueue = new LinkedList<>();
        positionQueue.offer(new Integer[]{1,1});

        while (!positionQueue.isEmpty()) {

            Integer[] curPosition = positionQueue.poll();

            for (int i = 0; i < 4; i++) {

                int nextY = curPosition[0] + dy[i];
                int nextX = curPosition[1] + dx[i];

                if(nextY >= 0 && nextY <= n && nextX >= 0 && nextX <= m) //범위 내
                    if (map[nextY][nextX] == 1 && counting[nextY][nextX] == 0) {
                        positionQueue.offer(new Integer[]{nextY, nextX});
                        counting[nextY][nextX] = counting[curPosition[0]][curPosition[1]] + 1;
                    }
            }
        }

        System.out.println(counting[n][m]);


        //인풋 맵 배열 선언
        //경로 카운팅 정수형 이차원 배열 생성, int[][] counting = new int[][];
        //포지션 저장하는 큐 생성
        //counting[1][1] = 1;
        //큐에 new Integer[]{1,1} 넣음
        //큐에 요소가 존재하는 동안 반복
        //  큐에서 요소 꺼냄
        //
        //  현재 위치의 상하좌우의 인덱스가 map의 범위를 넘지 않고, 요소의 값이 1이며, counting의 값이 0이라면
        //      counting 배열의 상하좌우 위치의 요소에 counting배열에서 현재 요소의 값에 +1 시켜서 저장 시킴
        //      큐에 넣음
        //
        //~반복 종료
        //map[n][m] 값 출력
    }

}
