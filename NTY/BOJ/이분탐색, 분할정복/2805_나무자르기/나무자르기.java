import java.util.*;
import java.io.*;

public class 나무자르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tree = new int[N];
        for (int i = 0; i < N; i++) tree[i] = Integer.parseInt(st.nextToken());

        int low = 0;    // 높이 최소
        int high = 1000000000;    // 높이 최대
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(tree, M, mid)) low = mid + 1;
            else high = mid - 1;
        }

        System.out.println(high);
    }

    private static boolean check(int[] tree, int M, int size) {
        long sum = 0;    // 합계가 int 범위 벗어날수도
        for (int n : tree) {
            if (n > size) sum += n - size;
        }
        return sum >= M;
    }
}