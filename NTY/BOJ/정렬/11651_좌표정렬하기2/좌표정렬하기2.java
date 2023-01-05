import java.io.*;
import java.util.*;

public class 좌표정렬하기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[1]){
                return o1[0] - o2[0];
            } else {
                return o1[0] - o2[1];
            }
        });

        for (int[] a : arr) {
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}