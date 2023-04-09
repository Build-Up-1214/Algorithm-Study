package baekjoon.stack_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 성공 **/
public class B4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input;
        List<String> list = new ArrayList<>();
        while (true) {

            input = bf.readLine();

            if(input.equals("."))
                break;

            list.add(input);
        }

        String[] result = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String st = list.get(i); //문자열 하나 꺼냄

            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < st.length(); j++) {

                char ch = st.charAt(j);

                if (ch == '[' || ch == '(') {
                    stack.push(ch);
                } else if (ch == ']') {
                    if (stack.empty() || !stack.peek().equals('[')) {
                        stack.push(ch);
                        break;
                    }
                    stack.pop();
                } else if (ch == ')') {
                    if (stack.empty() || !stack.peek().equals('(')) {
                        stack.push(ch);
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.empty()) {
                result[i] = "yes";
            } else {
                result[i] = "no";
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
