import java.io.*;
import java.util.*;

public class 카드정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long compare = 0L;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        while(N-- > 0) pq.add(Long.parseLong(br.readLine()));
        while(pq.size() > 1) {
            long mix = pq.poll() + pq.poll(); // 최소 2개 합치기
            compare += mix; // 누적
            pq.add(mix);    // 합친거 다시 큐에 저장
        }
        System.out.println(compare);
    }
}