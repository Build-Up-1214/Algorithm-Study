package baekjoon.greedy_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> pr = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            pr.add(Integer.parseInt(bf.readLine()));
        }

        int sum = 0;
        while (pr.size() > 1) {

            Integer min1 = pr.poll();
            Integer min2 = pr.poll();

            sum += (min1+min2);
            pr.add(min1 + min2);
        }

        System.out.println(sum);
    }
}
