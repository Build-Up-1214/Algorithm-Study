import java.io.*;
import java.util.*;

public class 최소힙 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 힙 -> 우선순위 큐(기본값이 최소 힙)

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){ // x가 0일 때
                if(pq.size() == 0) sb.append(0).append('\n');   // 큐에 아무것도 없으면 0 출력
                else sb.append(pq.poll()).append('\n'); // 최소 값 출력
            } else pq.offer(x);
        }

        System.out.println(sb);
    }
}