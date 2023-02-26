package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B1072_게임 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());

        long currentPercent = 100*y/x;


        if (currentPercent >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1000000000;

        while (left <= right) {

            long middle = (left + right) / 2;
            long tempY = y+middle;
            long tempX = x+middle;
            long tempPercent = 100*tempY/tempX;

            if (tempPercent > currentPercent) {
                right = middle-1;
            }
            else{
                left = middle+1;
            }
        }

        System.out.println(left);
    }
}
