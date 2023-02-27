import java.io.*;
import java.util.*;

public class 스택수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; // 수열
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        int x = 1;  // 스택에 추가할 수
        int index = 0;
        while(index <= n - 1) {
            if (!s.isEmpty() && s.peek() == arr[index]) {
                s.pop();
                sb.append('-').append('\n');
                index++;
            } else if (x <= n){
                s.push(x);
                sb.append("+").append('\n');
                x++;
            } else if (x > n) break; // n까지 숫자 넣은 후 pop 못하면 종료
        }

        System.out.println(s.isEmpty() ? sb : "NO");
    }
}