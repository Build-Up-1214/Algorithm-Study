import java.io.*;
import java.util.*;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String nString = br.readLine(); // 입력받은 수(String)

        // 우선순위 큐 이용
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < nString.length(); i++){
            // String -> char(각 자리 수)  -> int
            pq.offer(Integer.parseInt(String.valueOf(nString.charAt(i))));
        }

        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        System.out.println(sb); // 출력
        br.close();
    }
}