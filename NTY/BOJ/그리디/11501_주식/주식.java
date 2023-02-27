import java.util.*;
import java.io.*;

public class 주식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            long profit = 0;
            long max = Long.MIN_VALUE;
            for(int i = N - 1; i >= 0; i--) {
                if(arr[i] > max) max = arr[i];
                else profit += max - arr[i];
            }

            sb.append(profit).append('\n');
        }

        System.out.print(sb);
    }
}