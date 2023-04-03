package programmers.brute_force_완전탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 성공 **/
public class P_모의고사 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1,2,3,4,5}))); //[1]
        System.out.println(Arrays.toString(solution.solution(new int[]{1,3,2,4,2}))); //[1,2,3]
    }

    static class Solution {

        public int[] solution(int[] answers) {

            int[][] supo = new int[][]{{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
            int[] correctCtn = new int[3];

            for(int i = 0; i < answers.length; i++)
            {
                int correct = answers[i];

                //각 수포자들의 찍는 방식은 사이클이 반복이 되므로, 사이클 (length) 의 나머지값이 해당 수포자의 찍는 순서에 해당하는 답이다.
                if(supo[0][i % supo[0].length] == answers[i])
                    correctCtn[0]++;
                if(supo[1][i % supo[1].length] == answers[i])
                    correctCtn[1]++;
                if(supo[2][i % supo[2].length] == answers[i])
                    correctCtn[2]++;
            }


            //최고 점 구하기
            int maxCorrectCtn = 0;
            for(int i = 0; i < correctCtn.length; i++)
            {
                if(maxCorrectCtn < correctCtn[i])
                    maxCorrectCtn = correctCtn[i];
            }

            //최고점과 동등한 수포자 구하기
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < correctCtn.length; i++)
            {
                if(maxCorrectCtn == correctCtn[i])
                {
                    list.add(i+1);
                }
            }

            //List 형태의 동점자들을 배열로 변환
            return list.stream().mapToInt(i->i).toArray();

        }
    }


}
