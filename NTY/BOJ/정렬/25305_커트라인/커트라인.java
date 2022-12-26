import java.io.*;
import java.util.*;

public class 커트라인 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        int[] array = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(array);

        sb.append(array[N-k]);

        System.out.println(sb);
    }
}