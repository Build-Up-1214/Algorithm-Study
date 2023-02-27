package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 성공 **/
public class B1920_수찾기 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(bf.readLine());

        int[] result = new int[m];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            int value  = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = n-1;

            while (left <= right) {

                int mid = (left + right) / 2;

                if(arr[mid] == value) {
                    result[i] = 1;
                    break;
                } else if (arr[mid] > value) {
                    right = mid-1;
                } else if (arr[mid] < value) {
                    left = mid+1;
                }
            }
        }
        
        Arrays.stream(result).forEach(i-> System.out.println(i));
    }
}
