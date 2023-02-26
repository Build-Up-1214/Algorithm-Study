import java.util.*;
import java.io.*;

public class 통나무건너뛰기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) pq.add(Integer.parseInt(st.nextToken()));

            int root = pq.poll();
            int left = pq.poll();
            int right = pq.poll();
            int level = Math.abs(root - right);
            while (!pq.isEmpty()) {
                if(pq.size() == 1) level = Math.max(Math.abs(left - pq.poll()), level);
                else {
                    int addLeft = pq.poll();
                    level = Math.max(Math.abs(left - addLeft), level);
                    left = addLeft;

                    int addRight = pq.poll();
                    level = Math.max(Math.abs(right - addRight), level);
                    right = addRight;
                }
            }
            level = Math.max(Math.abs(left - right), level);
            sb.append(level).append('\n');
        }
        System.out.print(sb);
    }
}