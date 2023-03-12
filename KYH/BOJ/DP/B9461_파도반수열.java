package baekjoon.dp_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 성공, 제출 **/
public class B9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        int[] inputs = new int[t];

        for (int i = 0; i < t; i++) {
            inputs[i] = Integer.parseInt(bf.readLine());
        }

        long[] arr = new long[101];

        //핵심 점화식이 p(n-1) + p(n-5) 이기 때문에 미리 값을 넣어놔야함.
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;

        for (int i = 7; i < 101; i++) {
            arr[i] = arr[i-1] + arr[i-5]; //핵심 점화식
        }

        for (int i = 0; i < inputs.length; i++) {
            System.out.println(arr[inputs[i]]);
        }
    }
}
