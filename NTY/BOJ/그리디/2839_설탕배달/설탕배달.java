import java.io.*;

public class 설탕배달 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        while(N > 0) {
            if(N % 5 == 0) {
                result += N / 5;
                break;
            }
            N -= 3;
            result++;
        }
        result = N >= 0 ? result : -1;
        System.out.println(result);
    }
}