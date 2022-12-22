package baekjoon.sort_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2012_등수매기기 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        solution(n, arr);
    }

    public static void solution(int n, int[] arr) {

        //수도코드
        //예상 등수를 오름차순으로 정렬
        //누적 불만도 저장 변수 선언
        //i = 1~n까지 반복문 시작
        //  |i - 예상등수| 을 누적 불만도에 저장
        //반복문 종료

        Arrays.sort(arr);

        //핵심 부분이다. 해당 부분의 타입이 int형일 경우 실패한다.
        //왜냐하면 인원수는 최대 500,000명이 존재할 수 있다.
        //그리고 500,000명 모두가 1등을 예상한다면
        //|1 - 1| + |1 - 2| ... + |1 - 500000| 모두 다 더하면 int의 범위를 벗어나기 때문이다.
        long totalNegative = 0;

        for (int i = 0; i < n; i++) {
            int negative = Math.abs(arr[i] - (i + 1));
            totalNegative += negative;
        }
        System.out.println(totalNegative);
    }
}
