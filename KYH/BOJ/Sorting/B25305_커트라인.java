package baekjoon.sort_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/** 성공, 퀵정렬 사용 **/
public class B25305_커트라인 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(bf.readLine());

        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(score, 0, score.length-1);

        System.out.println(score[k-1]);

    }

    private static void quickSort(int[] score, int start, int end) {

        int part2Start = partition(score, start, end);

        //구해진 우측 파트의 시작 인덱스 - 1이 최초의 start 보다 작지 않다면
        //좌측파트는 더이상 소팅할것이 없기에 조건 검사
        if (start < part2Start - 1) {
            quickSort(score, start, part2Start - 1);
        }

        //구해진 우측 파트의 시작 인덱스가 최초의 end 보다 작지 않다면
        //우측파트는 더이상 소팅할것이 없기에 조건 검사
        if (part2Start < end) {
            quickSort(score, part2Start, end);
        }

    }

    /** 피봇값을 기준으로 우측은 작은값, 좌측은 큰값으로 정렬한다
     *  그리고 리턴 값은 나뉘어진 파트 중 우측 파트의 시작 인덱스를 반환
     * **/
    private static int partition(int[] score, int start, int end) {

        int pivot = score[(start + end) / 2]; //피봇 값을 구함. 해당 메소드에서 기준이 되는 값

        while (start <= end) { //시작 인덱스(좌측파트 조회 인덱스) 와 끝 인덱스(우츠 파트 조회 인덱스) 가 어긋나는 상황이 아니라면 반복

            while(score[start] > pivot) start++; //좌측 파트의 인덱스 위치의 값이 피봇 보다 크다면 통과함
            while(score[end] < pivot) end--; //우측 파트의 인덱스 위치의 값이 피봇 보다 작다면 통과함

            if(start <= end){ //만약 좌우측 파트의 조회 인덱스가 어긋나지 않은 상황이라면, 교환해야할것이 존재한다는 의미
                int temp = score[start];
                score[start] = score[end];
                score[end] = temp;
                start++; //다음것을 조회하기 위해
                end--; //다음것을 조회하기 위해
            }
        }
        return start; //피봇보다 작은 범위의 시작
    }

}
