import java.io.*;

public class 잃어버린괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine() + "-";

        int plus = 0;
        int minus = 0;
        String temp = "";
        char symbol = '+';  // 0 + 부터 시작이라 생각
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-') {
                if(symbol == '+') {
                    plus += Integer.parseInt(temp);
                    if(c == '-') symbol = '-';  // 마이너스로 체인지
                } else minus += Integer.parseInt(temp);
                temp = "";
            } else temp += String.valueOf(s.charAt(i));
        }

        System.out.println(plus-minus);
    }
}