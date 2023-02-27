package baekjoon.greedy_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공 **/
public class B1931_회의실배정 {
    static int[][] meetings;
    public static void main(String[] args) throws IOException {

        //문제의 핵심
        //일찍 종료되는 회의순으로 정렬한다.
        //회의가 일찍 종료될 수록 많은 회의실이 비는 시간이 더 많아지므로, 가능한 회의수가 증가하게 된다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        meetings = new int[n][];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            meetings[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(meetings, (m1, m2) -> {
            //종료 시간이 같으면 시작 시간이 빠른것을 앞쪽으로 정렬 해줘야함
            //그렇지 않으면 아래와 같은 반례에서 예외 발생
            //3
            //1 3
            //8 8
            //4 8
            //인 상황에서 (8 8) 과 (4 8)을 swap 시키지 않으면
            //가능한 회의는 2개밖에 안될것이다
            //하지만
            //3
            //1 3
            //4 8
            //8 8
            //이렇게 정렬을 해준다면
            //3개의 회의가 가능해진다.
            if(m1[1] == m2[1])
            {
                return m1[0] - m2[0];
            }

            return m1[1] - m2[1];
        } );

        int ctn = 0;
        int preEnd = 0;
        for (int i = 0; i < n; i++) {
            if(meetings[i][0] >= preEnd)
            {
                ctn++;
                preEnd = meetings[i][1];
            }
        }
        System.out.println(ctn);
    }

}
