import java.io.*;
import java.util.*;

public class 랜선자르기 {
    /*
    랜선길이 최대가 int 범위 넘어가기때문에 long
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        long max = 1L;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = arr[i] > max ? arr[i] : max;
        }

        long low = 1L;
        long high = max;
        while(low <= high) {
            long mid = (low + high) / 2;
            if (check(arr, N, mid)) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println(high);
    }

    private static boolean check(long[] arr, int N, long size) {
        long count = 0;
        for (long n : arr) count += n / size;
        return count >= N;
    }
}