import java.util.*;
import java.io.*;

public class 마인크래프트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int max = 0;
        int min = 256;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > max) max = arr[i][j];
                if (arr[i][j] < min) min = arr[i][j];
            }
        }

        int height = 0;
        int time = 500 * 500 * 256 * 2; // 높이 최대로 쌓았을 때 걸린 시간
        while(min <= max){
            int count = 0;
            int block = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] >= min) {
                        count += 2 * (arr[i][j] - min);
                        block += arr[i][j] - min;
                    } else {
                        count += min - arr[i][j];
                        block -= min - arr[i][j];
                    }
                }
            }
            if(block >= 0 && count <= time) {    // 시간 같을때 높이 더 높은걸로
                height = min;
                time = count;
            }
            min++;
        }

        sb.append(time).append(' ').append(height);
        System.out.println(sb);
    }
}