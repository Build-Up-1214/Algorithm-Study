package baekjoon.brute_force_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 성공 **/
public class B2798_블랙잭 {

    static int[] cards;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cards = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        binarySearchSolve();
    }

    //반복문 사용 솔루션
    private static void bruteforceSolve() {

        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int z = j + 1; z < n; z++) {

                    int sum = cards[i] + cards[j] + cards[z];
                    if(m >= sum && sum > max)
                        max = sum;
                }
            }
        }

        System.out.println(max);
    }

    //이분탐색 사용 솔루션
    private static void binarySearchSolve() {

        int left;
        int mid ;
        int right;
        int max = 0;

        Arrays.sort(cards);
        for (int i = 0; i < n - 2; i++) {

            left = i;
            mid = i + 1;
            right = n - 1;

            while (mid < right) {

                int sum = cards[left] + cards[mid] + cards[right];

                if (sum <= m && sum > max) {
                    max = sum;
                }

                if (sum > m) {
                    right--;
                }
                else {
                    mid++;
                }

            }
        }

        System.out.println(max);
    }
}
