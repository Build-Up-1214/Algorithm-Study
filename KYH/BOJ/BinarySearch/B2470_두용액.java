package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 성공 **/
public class B2470_두용액 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        int min = Integer.MAX_VALUE;
        int sum;
        int result1 = 0;
        int result2 = 0;

        while (left < right) {

            sum = arr[left] + arr[right];

            if (Math.abs(sum)< min) {

                result1 = arr[left];
                result2 = arr[right];
                min = Math.abs(sum);
            }

            if (sum > 0) {
                right--;
            }
            else {
                left++;
            }
        }

        System.out.println(result1 + " " + result2);
    }
}
