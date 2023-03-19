package baekjoon.brute_force_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19532_수학은비대면강의입니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] input = new int[6];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < 6; i++){input[i] = Integer.parseInt(st.nextToken());}

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {

                int result1 = (input[0] * i) + (input[1] * j);
                int result2 = (input[3] * i) + (input[4] * j);

                if(result1 == input[2] && result2 == input[5]) {
                    System.out.println(i + " " + j);
                    break;
                }

            }
        }

    }
}
