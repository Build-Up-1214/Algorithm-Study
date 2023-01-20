package baekjoon.dp_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 성공 **/
public class B9095_123더하기 {
    public static void main(String[] args) throws IOException {

        int[] number = new int[11];

        //미리 답을 알 수 있는 요소들
        number[0] = 0;
        number[1] = 1;
        number[2] = 2;
        number[3] = 4;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //규칙을 찾는 방법
        //예를 들어
        //1,2,3을 이용하여 4가 만들어질 수 있는 상황은
        //~무슨 수 + 1 = 4 -> 무슨 수 = 3 -> 3의 경우의 수
        //~무슨 수 + 2 = 4 -> 무슨 수 = 2 -> 2의 경우의 수
        //~무슨 수 + 3 = 4 -> 무슨 수 = 1 -> 1의 경우의 수
        //그러므로 "3의 경우의 수" + "2의 경우의 수" + "1의 경우의 수"

        for (int i = 4; i < 11; i++) {
            number[i] = number[i-1] + number[i - 2] + number[i - 3];
        }

        int t = Integer.parseInt(bf.readLine());
        int[] inputArr = new int[t];
        for (int i = 0; i < t; i++) {
            inputArr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.stream(inputArr).forEach(i-> System.out.println(number[i]));
    }
}
