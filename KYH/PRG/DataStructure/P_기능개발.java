package programmers.stack_queue_스택큐.P_기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 성공, 자료구조가 쓰여지진 않음 (자료구조 사용한 레퍼런스 코드가 오히려 비효율적) **/
public class P_기능개발 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};

        System.out.println(Arrays.toString(solution.solution(progresses, speeds)));

    }
}


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int curIdx = 0;
        List<Integer> deployCountOfDay = new ArrayList<>();

        while(curIdx < progresses.length)
        {
            for(int i = 0; i < progresses.length; i++)
            {
                progresses[i] += speeds[i];
            }

            if(progresses[curIdx] >= 100)
            {
                int count = 0;
                for(int i = curIdx; i < progresses.length; i++)
                {
                    if(progresses[i] >= 100)
                    {
                        count++;
                        curIdx = i+1;
                    }
                    else
                    {
                        break;
                    }
                }
                deployCountOfDay.add(count);
            }
        }

        return deployCountOfDay.stream().mapToInt(i->i).toArray();
    }
}