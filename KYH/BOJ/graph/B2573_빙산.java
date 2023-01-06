package baekjoon.graph_그래프.dfs_깊이우선탐색;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/** 성공, 빙하 녹일때 필요한 빙하좌표를 미리 넣어둠으로써 메모리와 시간단축 **/
public class B2573_빙산 {

    static int r,c;
    static int[][] map;
    static int day = 0;
    static int[] dr = new int[]{-1,1,0,0};
    static int[] dc = new int[]{0,0,-1,1};
    static Queue<Integer[]> icePosition = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int iceCtn = 0;
        while ((iceCtn = countIce()) < 2) {
            if(iceCtn == 0)
                break;
            day++;
            melt();
        }

        if(iceCtn == 0)
            System.out.println(0);
        else
            System.out.println(day);

    }

    private static void melt() { //빙하 녹이기

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (map[i][j] != 0) {
                    visited[i][j] = true;
                }
            }
        }


        while (!icePosition.isEmpty()) {

            Integer[] ice = icePosition.poll();

            int waterSideCtn = 0;

            for (int i = 0; i < 4; i++) {

                int nextR = ice[0] + dr[i];
                int nextC = ice[1] + dc[i];

                if (nextR >= 0 && nextR < r && nextC >= 0 && nextC < c) {

                    //아래 조건에서 !visited[nextR][nextC] 를 추가해줌으로써 이번 melt단계에서 녹은, 원래 빙하였던 포지션을 제외시켜준다.
                    if (map[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                        waterSideCtn++;
                    }
                }
            }

            if(map[ice[0]][ice[1]] - waterSideCtn > 0)
                map[ice[0]][ice[1]] -= waterSideCtn;
            else
                map[ice[0]][ice[1]] = 0;
        }

    }

    private static int countIce() { //빙하덩이 갯수 세기

        int ice = 0;

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0) {

                    //빙하 녹일때 필요한 빙하의 좌표를 미리 큐에 넣어 둠
                    icePosition.offer(new Integer[]{i, j});

                    if(visited[i][j])
                        continue;

                    ice++;
                    Stack<Integer[]> iceAreaPosition = new Stack<>();

                    visited[i][j] = true;
                    iceAreaPosition.push(new Integer[]{i,j});


                    while (!iceAreaPosition.empty()) {
                        Integer[] position = iceAreaPosition.pop();

                        for (int z = 0; z < 4; z++) {
                            int nextR = position[0] + dr[z];
                            int nextC = position[1] + dc[z];

                            if(nextR >= 0 && nextR < r && nextC >= 0 && nextC < c)
                                if(!visited[nextR][nextC] && map[nextR][nextC] != 0)
                                {
                                    visited[nextR][nextC] = true;
                                    iceAreaPosition.push(new Integer[]{nextR,nextC});
                                }

                        }

                    }
                }
            }
        }
        return ice;
    }


}
