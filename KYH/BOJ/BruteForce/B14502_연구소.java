package baekjoon.brute_force_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공 **/
public class B14502_연구소 {
    static int[][] map;
    static List<Integer[]> emptyList;
    static List<Integer[]> virusList;
    static int n;
    static int m;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        //전체 흐름 수도코드
        //모든 경우의수를 생각하여 벽 설치 로직
        //감염 로직
        //칸 수 확인 로직

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        emptyList = new ArrayList<>();
        virusList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if(value == 0)
                    emptyList.add(new Integer[]{i,j});
                else if(value == 2)
                    virusList.add(new Integer[]{i,j});
            }
        }
        buildWall();
        System.out.println(max);
    }

    private static void buildWall() {

        for (int i = 0; i < emptyList.size() - 2; i++) {
            for (int j = i + 1; j < emptyList.size() - 1; j++) {
                for (int z = j + 1; z < emptyList.size(); z++) {
                    Integer[] wall1 = emptyList.get(i);
                    Integer[] wall2 = emptyList.get(j);
                    Integer[] wall3 = emptyList.get(z);
                    map[wall1[0]][wall1[1]] = 1;
                    map[wall2[0]][wall2[1]] = 1;
                    map[wall3[0]][wall3[1]] = 1;

                    infection();

                    map[wall1[0]][wall1[1]] = 0;
                    map[wall2[0]][wall2[1]] = 0;
                    map[wall3[0]][wall3[1]] = 0;
                }
            }
        }
    }

    private static void infection() {

        Queue<Integer[]> queue = new LinkedList<>(virusList);

        int[][] copy = copyMap();
        boolean[][] checked = new boolean[n][m];

        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};

        while (!queue.isEmpty()) {

            Integer[] position = queue.poll();

            for (int i = 0; i < 4; i++) {

                int newCol = position[1] + dx[i];
                int newRow = position[0] + dy[i];
                if (newCol >= 0 && newRow >= 0 && newCol < m && newRow < n) {
                    if (copy[newRow][newCol] == 0 && !checked[newRow][newCol]) {
                        checked[newRow][newCol] = true;
                        queue.add(new Integer[]{newRow,newCol});
                        copy[newRow][newCol] = 2;
                    }

                }
            }
        }
        countSafetyArea(copy);
    }

    private static void countSafetyArea(int[][] copyMap) {

        int ctn = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    ctn++;
                }
            }
        }

        if (ctn > max) {
            max = ctn;
        }
    }

    private static int[][] copyMap() {

        int[][] copyMap = new int[n][];
        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }
        return copyMap;
    }
}
