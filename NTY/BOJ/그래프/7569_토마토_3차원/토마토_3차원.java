import java.util.*;
import java.io.*;

public class 토마토_3차원 {
    private static int M, N, H;
    private static int empty;   // 토마토가 없는 칸 수
    private static int count1;  // 익은 토마토 수
    private static int count0;  // 안 익은 토마토 수
    private static int time;    // 경과 시간(날짜)
    private static int[][][] tomato;  // 토마토 위치 및 상태
    private static Queue<int[]> point = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer MNH = new StringTokenizer(br.readLine());

        M = Integer.parseInt(MNH.nextToken());   // 가로 칸
        N = Integer.parseInt(MNH.nextToken());   // 세로 칸
        H = Integer.parseInt(MNH.nextToken());   // 높이

        // 초기화
        tomato = new int[H][N][M];  // 높이/가로/세로
        empty = 0;
        count0 = 0;
        count1 = 0;

        // 입력값 저장
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    // 토마토 상태에 따라 카운트
                    if (input == -1) empty++;
                    if(input == 0) count0++;
                    if (input == 1) {
                        point.offer(new int[] {k, i, j});
                        count1++;
                    }
                    tomato[k][i][j] = input;
                }
            }
        }

        time = 0;   // 초기화

        if (empty + count1 != M * N * H) {  // 토마토가 없는 칸을 제외하고 모든 토마토가 익어있는 상태가 아니면
            dfs();  // 익을때 까지 걸리는 최소 날짜 계산
            if (count0 != 0) {  // 초기에 익지않은 토마토 수에서 최소 날짜 계산 후 남은 토마토가 0이 아니면 -> 모두 익지는 못하는 상황
                time = -1;
            }
        }

        System.out.println(time);
    }

    public static void dfs() {
        while(count0 > 0 && !point.isEmpty()) { // 토마토가 모두 익었거나(0이 남지 않은 경우) 큐에 저장된 값이 없으면(0이 남은 경우) 끝
            int count_new = count1; // 이전단계에서 0 -> 1이 된 토마토 수
            count1 = 0; // 0 -> 1 토마토 수 카운트 하기 위해 초기화
            while(count_new-- > 0) {    // 이전단계에서 0 -> 1이 된 토마토 수 만큼 반복 -> 0 -> 1이 된 토마토 기준으로 상하좌우 익는 토마토 계산
                int[] point_temp = point.poll();
                int z = point_temp[0];
                int x = point_temp[1];
                int y = point_temp[2];

                // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤  계산
                if (x - 1 >= 0 && tomato[z][x - 1][y] == 0) {
                    tomato[z][x - 1][y] = 1;   // 토마토 익게 만들고
                    point.offer(new int[] {z, x - 1, y});
                    count1++;   // 익은(0 -> 1) 토마토 수 증가
                    count0--;   // 익지(0) 않은 토마토 수 감소
                }
                if (x + 1 <= N - 1 && tomato[z][x + 1][y] == 0) {
                    tomato[z][x + 1][y] = 1;
                    point.offer(new int[] {z, x + 1, y});
                    count1++;
                    count0--;
                }
                if (y - 1 >= 0 && tomato[z][x][y - 1] == 0) {
                    tomato[z][x][y - 1] = 1;
                    point.offer(new int[] {z, x, y - 1});
                    count1++;
                    count0--;
                }
                if (y + 1 <= M - 1 && tomato[z][x][y + 1] == 0) {
                    tomato[z][x][y + 1] = 1;
                    point.offer(new int[] {z, x, y + 1});
                    count1++;
                    count0--;
                }
                if (z - 1 >= 0 && tomato[z - 1][x][y] == 0) {
                    tomato[z - 1][x][y] = 1;
                    point.offer(new int[] {z - 1, x, y});
                    count1++;
                    count0--;
                }
                if (z + 1 <= H - 1 && tomato[z + 1][x][y] == 0) {
                    tomato[z + 1][x][y] = 1;
                    point.offer(new int[] {z + 1, x, y});
                    count1++;
                    count0--;
                }

            }
            time++; // 날짜 카운트
        }
    }
}