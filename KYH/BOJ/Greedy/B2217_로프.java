package baekjoon.greedy_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 자율 **/
public class B2217_로프 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);

        int max = 0;

        for (int i = 0; i < n; i++) {

            int tempMax = (n-i) * arr[i];
            if (tempMax > max) {
                max = tempMax;
            }
        }

        System.out.println(max);
    }
}
