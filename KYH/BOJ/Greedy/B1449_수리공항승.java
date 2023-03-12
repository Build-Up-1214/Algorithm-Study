package baekjoon.greedy_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 성공, 제출 **/
public class B1449_수리공항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] holes = new int[n];

        for (int i = 0; i < n; i++) {
            holes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(holes);
        int curHole = holes[0];
        int tapeCtn = 1;
        for (int i = 0; i < n; i++) {

            if (curHole + l <= holes[i]) {
                tapeCtn++;
                curHole = holes[i];
            }
        }

        System.out.println(tapeCtn);
        //현재 파손 위치 변수
        //테이프 갯수, 1으로 시작
        //반복문 시작, holes 순차 접근,
        //  만약 curHole + l 보다 작지 않으면
        //      테이프갯수++
        //      현재 파손 위치 변수 = 현재 파손 위치

        //~종료

    }
}
