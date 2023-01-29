package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 성공 **/
public class B10815_숫자카드 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] sCard = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            sCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sCard);

        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {

            int card = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = n-1;
            boolean find = false;
            while (left <= right) {

                int mid = (left + right) / 2;

                if(sCard[mid] == card)
                {
                    find = true;
                    break;
                } else if (sCard[mid] < card) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            if(find)
                sb.append("1 ");
            else
                sb.append("0 ");
        }

        System.out.println(sb);
    }
}
