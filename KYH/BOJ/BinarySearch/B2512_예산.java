package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] house = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int max = 0;
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(st.nextToken());
            if(max < house[i])
                max = house[i];
        }

        int m = Integer.parseInt(bf.readLine());

        //각 요청 예상은 최소 1이상이고,
        //총 예산 m은, n <= m <= 1000000000 이기 때문에 최소 1씩은 줄 수 있다.
        //그로 인해 최소 범위를 1부터 시작한다
        int left = 1;
        int right = max;

        while (left <= right) {

            int mid = (left + right) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.min(house[i], mid);
            }

            if (sum > m) {
                right = mid-1;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}
