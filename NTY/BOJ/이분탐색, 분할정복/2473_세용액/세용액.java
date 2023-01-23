import java.io.*;
import java.util.*;

public class 세용액 {
    private static long x1, x2, x3;
    private static boolean zero;
    private static long max = 3000000000L;  // 입력 합계 최대값의 절대값
    private static long[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        for (int i = 0; i < N - 2; i++){
            f(i, i + 1, N - 1);
            if(zero) break;
        }

        sb.append(x1).append(" ").append(x2).append(" ").append(x3);
        System.out.println(sb);
        br.close();
    }

    private static void f(int index, int low, int high) {
        while (low < high) {
            long sum = arr[index] + arr[low] + arr[high];
            if(sum == 0) {
                x1 = arr[index];
                x2 = arr[low];
                x3 = arr[high];
                zero = true;
                break;
            }
            if(Math.abs(sum) < max) {
                x1 = arr[index];
                x2 = arr[low];
                x3 = arr[high];
                max = Math.abs(sum);
            }
            if (sum > 0) high -= 1;
            else low += 1;
        }
    }
}