import java.io.*;
import java.util.*;

public class 연산자끼워넣기 {
    private static int min = 1000000000;
    private static int max = -1000000000;
    private static int[] arr, op;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        op = new int[4];    // 연산자 4개
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) op[i] = Integer.parseInt(st.nextToken());

        calculate(arr[0], 1);

        System.out.println(max + "\n" + min);
    }

    private static void calculate(int n, int d) {
        if(d == arr.length) {
            min = Math.min(n, min);
            max = Math.max(n, max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                if(i == 0) calculate(n + arr[d], d + 1);
                else if(i == 1) calculate(n - arr[d], d + 1);
                else if(i == 2) calculate(n * arr[d], d + 1);
                else calculate(n / arr[d], d + 1);
                op[i]++;    // 백트래킹
            }
        }
    }
}