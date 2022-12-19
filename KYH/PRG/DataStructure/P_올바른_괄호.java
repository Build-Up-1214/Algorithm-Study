package programmers.stack_queue_스택큐.P_올바른_괄호;

import java.util.*;

/** 성공, 큐 사용 **/
public class P_올바른_괄호 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solution("()()"); //true
        solution.solution("(())()"); //true
        solution.solution(")()("); //false
        solution.solution("(()("); //false

    }
}

class Solution {
    boolean solution(String s) {

        //s의 요소 탐색 반복문 시작
        //  만약 이번에 queue에 넣을 요소가 ( 라면
        //      그냥 넣기만 함
        //  만약 이번에 queue에 넣을 요소가 ) 라면
        //      queue에 헤드를 검사한다
        //          만약 )라면 바로 false 리턴
        //          만약 (라면 queue에서 헤드 요소 빼냄
        //~반복문 종료
        //정상적으로 (와 )가 짝지어서 offer, poll 됬다면 queue에는 요소가 0개여야 한다.
        //그렇지 않을 경우 false 리턴
        //위에 로직에서 아무런 조건에도 걸리지 않은 경우 true 리턴

        boolean answer = true;

        Queue<Character> queue = new LinkedList();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if(c == '(')
            {
                queue.offer(c);
            }
            else
            {
                Character head = queue.peek();
                if(head == null || head == ')')
                    return false;
                else
                    queue.poll();
            }
        }

        if(queue.size() != 0)
            return false;

        return answer;
    }
}
