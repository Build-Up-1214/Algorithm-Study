import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        for(char c : cs){
            if(c == '(') stack.push(c);
            else if(c == ')'){
                if(!stack.empty() && stack.peek() == '(') stack.pop();
                else return false;
            }
        }
        return stack.empty();
    }
}