package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(house);

        int left = 1;
        int right = house[n-1] - house[0];
        int ans = 1; //최소 간격간 최대 거리
        while (left <= right) {

            int mid = (left + right) / 2;
            int previousHouse = 0;
            int setCtn = 1;


            for (int i = 1; i < n; i++) {
                int dist = house[i] - house[previousHouse];

                if (dist >= mid) {
                    previousHouse = i;
                    setCtn++;
                }
            }

            if (setCtn >= c) {
                left = mid + 1;
                ans = Math.max(ans, mid); //기록
            }
            else
            {
                right = mid - 1;
            }
        }


        System.out.println(ans);

    }
}
