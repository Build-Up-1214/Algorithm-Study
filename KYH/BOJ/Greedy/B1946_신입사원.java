package baekjoon.greedy_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(bf.readLine());

            int[] score = new int[n+1]; //성적은 1부터 시작하기 때문에, 편의를 위해


            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(bf.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int meeting = Integer.parseInt(st.nextToken());

                //가장 중요한 부분
                //서류 등수가 인덱스로 쓰임으로써, 인덱스 자체가 서류 등수로 정렬이 되었고
                //각 서류 점수와 매칭되는 면접 점수의 값을 할당함
                score[paper] = meeting;
            }

            //score[1]은 이미 통과자이다. 왜냐하면 1번째 인덱스라는 것은 서류등수가 이미 1등이라는 것이기 때문이다.
            //그렇기 때문에 score[1]에 할당된 면접 등수와는 상관없이 뒤에 인덱스 사원 중 무조건 1명 이상 보다 등수가 높으므로 합격 가능
            //이미 한명이 합격된 상태로 시작된다.
            int passCtn = 1; //합격자 수.
            int meetingOfUpperPaper = score[1]; //서류면접 등수 상위자인 사원의 면접 점수
            for (int j = 2; j <= n; j++) { //어차피 한격인 1인덱스 사원을 제외하고 체크

                //j번째 인덱스 사원의 면접 점수가 서류 등수 상위자 중 최소 한명한테라도 면접 등수가 높기 때문에 합격대상이 됨
                if (meetingOfUpperPaper > score[j]) {

                    meetingOfUpperPaper = score[j];
                    passCtn++;
                }
            }

            sb.append(passCtn+"\n");
        }

        System.out.println(sb);
    }
}
