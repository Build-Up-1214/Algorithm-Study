import java.util.*;
import java.io.*;

public class N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(i == 0) pq.offer(temp);  // 우선순위 큐에 첫번째 줄 N개 저장
                else {  // 두번째 줄부터 비교
                    if (pq.peek() < temp) { // 큐에 저장 되어있는 수중 제일 작은 수(peek()값) 보다 크면
                        pq.poll();  // 한 자리 비우고
                        pq.offer(temp); // 저장
                    }
                }
            }
        }

        System.out.println(pq.poll());  // 우선순위큐에 맨 앞에 있는 수(큐에 있는 수 중 제일 작은 수), 즉 1~N 번째 수중 N 번째
        br.close();
    }
}