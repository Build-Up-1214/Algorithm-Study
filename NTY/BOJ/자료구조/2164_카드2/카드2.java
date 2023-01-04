import java.io.*;
import java.util.*;

public class 카드2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        if(N == 1) queue.offer(1);  // n이 1일때
        else if (N % 2 == 0) {  // N이 짝수일때, 홀수제외하고 체워넣는다
            for (int i = 2; i <= N; i+=2) {
                queue.offer(i);
            }
        }
        else {  // 1아닌 홀수일때 짝수 채워넣고 마지막에 2 넣는다
            for (int i = 4; i <= N; i+=2) {
                queue.offer(i);
            }
            queue.offer(2);
        }



        while (queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        bw.write(String.valueOf(queue.peek()));
        bw.flush();
        bw.close();
        br.close();
    }
}