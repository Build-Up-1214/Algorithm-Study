import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// BigInteger -> 큰 숫자
public class 조합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BigInteger num1 = BigInteger.ONE;
        BigInteger num2 = BigInteger.ONE;
        for(int i=0; i<M; i++) {
            num1 = num1.multiply(new BigInteger(String.valueOf(N-i)));
            num2 = num2.multiply(new BigInteger(String.valueOf(i+1)));
        }
        System.out.println(num1.divide(num2));
    }


}