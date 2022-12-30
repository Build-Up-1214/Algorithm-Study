package baekjoon.sort_정렬;

import java.util.Scanner;

/** 성공 **/
public class B23881_알고리즘_수업_선택_정렬1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        for (int i = n - 1; i >= 1; i--) {

            int maxIdx = i;

            for (int j = i - 1; j >= 0; j--) {

                if(arr[maxIdx] < arr[j])
                    maxIdx = j;
            }

            if (maxIdx != i) {
                count++;

                if (count == k) {
                    System.out.printf("%d %d\n", arr[i], arr[maxIdx]);
                    return;
                }

                long temp = arr[maxIdx];
                arr[maxIdx] = arr[i];
                arr[i] = temp;
            }
        }

        System.out.println(-1);
    }
}
