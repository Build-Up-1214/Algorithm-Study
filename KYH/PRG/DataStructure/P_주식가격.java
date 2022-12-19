package programmers.stack_queue_스택큐.P_주식가격;

import java.util.Arrays;

/** 성공, 자료구조가 쓰여지진 않음 (자료구조 사용한 레퍼런스 코드가 오히려 비효율적) **/
public class P_주식가격 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 2, 3}))); //[4, 3, 1, 1, 0]
    }
}

class Solution {
    public int[] solution(int[] prices) {

        //매초마다의 가격이 주식 가격이 떨어지지 않은 총 시간을 담을 배열 생성
        //현재 초의 가격을 기준으로 이후 초의 가격이 떨어졌는지 검사하기 위해 이중 반복문을 사용
        //"현재 초 가격" 과 "j번째 초의 가격" 을 비교하여 가격이 떨어진 순간 현재 초와 떨어진 순간 초의 차이를 1라인에서 만든 배열에 할당하면 됨

        //매초의 주식 가격 배열 반복문 시작 (i 고정)
        //  현재 초(i) 이후!의 주식 가격을 조회하는 반복문 시작 (j 인덱스로 조회)
        //      1초 뒤에 바로 가격이 떨어져도 그 1초를 떨어지지 않은 시간(초)로 생각하기 때문에 우선 1초 경과 시킴
        //      만약 i번째 주식값 보다 j번째 주식값이 낮은 경우
        //          이미 주식값이 떨어진 초를 구했기 때문에 반복문종료
        //  증가된 초를 결과 배열에 저장
        //  ~ 반복문 종료
        //~반복문 종료

        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++)
        {
            for(int j = i + 1; j < prices.length; j++)
            {
                answer[i]++;
                if(prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}
