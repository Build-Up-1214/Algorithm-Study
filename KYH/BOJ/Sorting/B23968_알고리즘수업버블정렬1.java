package baekjoon.sort_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B23968_알고리즘_수업_버블_정렬1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = n - 1; i > 0; i--) {

            for (int j = 0; j < n - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    count++;
                    if (count == k) {
                        System.out.printf("%d %d\n", arr[j+1], arr[j]);
                        return;
                    }

                    long temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println(-1);

    }
}


