import java.io.*;
import java.util.*;

public class ATM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(P); // 인출하는데 필요한 시간이 작은 순대로 정렬

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) count += P[j];
        }

        System.out.println(count);
    }
}