import java.io.*;
import java.util.*;

public class 절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(queue.isEmpty()) sb.append(0).append('\n');
                else sb.append(queue.poll()).append('\n');
            } else queue.add(x);
        }

        System.out.println(sb);
    }
}