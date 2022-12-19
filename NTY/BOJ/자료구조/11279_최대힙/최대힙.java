import java.io.*;
import java.util.*;

public class 최대힙 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력

        int N = Integer.parseInt(br.readLine());    // 명령 수
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 최대 힙 -> 우선순위 큐(기본 최소힙) 이용

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());    // 숫자 하나 읽음
            if(x == 0) {    // 명령어 숫자가 0 이면
                if(!pq.isEmpty()) bw.write(pq.poll() + "\n");   // 큐 값이 존재하면 큰 값을 내보내고 출력
                else bw.write(0 + "\n");    // 큐 값이 존재하지 않으면 0
            } else {
                pq.add(x);  // 명령어 숫자가 0이 아니면 큐에 저장
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}