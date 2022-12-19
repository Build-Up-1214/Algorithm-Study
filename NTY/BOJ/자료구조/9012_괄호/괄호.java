import java.io.*;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력

        int T = Integer.parseInt(br.readLine());    // 입력 갯수

        for(int i = 0; i < T; i++){ // 입력 갯수 만큼 반복
            Stack<String> stack = new Stack<>();    // 괄호 문자열 담을 스택 생성
            String[] s = br.readLine().split("");   // 괄호 문자열을 하나씩 나눔
            for(int j = 0; j < s.length; j++){  // 문자열 길이 만큼 반복
                if(s[j].equals("(")) stack.push("(");   // 괄호 문자가 "(" 이면 스택에 저장
                else if(s[j].equals(")")) { // 괄호 문자가 ")" 이면
                    if(!stack.empty() && stack.peek().equals("(")) stack.pop();  // 스택이 비어 있지 않고, 스택의 top 값이 "("인 경우 pop -> () 일경우
                    else{
                        bw.write("NO" + "\n");  // 이외는 NO -> "(" 이 없는 상황에서 ")" 만 있을경우 규칙 성립하지 않음
                        break;  // NO 이므로 반복문 종료
                    }
                }
                if(j == s.length - 1){  // 반복문 다 돌고 마지막일때
                    if(stack.empty()) bw.write("YES" + "\n");   // 스택이 비어있으면 YES -> () 딱 맞아 떨어짐
                    else bw.write("NO" + "\n");     // "(" 이 남아 있는 경우
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
