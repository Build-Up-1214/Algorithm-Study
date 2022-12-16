import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        // '('가 나오면 stack에 push 하고 ')'가 나오면 '('를 pop한다.
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push('(');
            else {
                if (stack.size() == 0) return false;
                else stack.pop();
            }
        }
        if (stack.size() != 0) return false;
        else return answer;
    }
}