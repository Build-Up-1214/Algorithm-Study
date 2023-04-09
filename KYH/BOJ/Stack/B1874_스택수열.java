package baekjoon.stack_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 성공 **/
public class B1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack();
        List<String> result = new ArrayList();
        int n = Integer.parseInt(bf.readLine());

        int[] a = new int[n + 1];
        int m = 1;
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            result.add("+");
            while (!stack.empty() && stack.peek() == a[m]) {
                stack.pop();
                result.add("-");
                m++;
            }
        }

        if (stack.empty()) {
            for (String s : result) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
}
