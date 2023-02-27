import java.io.*;
import java.util.*;

public class A_B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 1;
        while(B > A) {
            if((B - 1) % 10 == 0) B = (B - 1) / 10;
            else if(B % 2 == 0) B /= 2;
            else break;
            count++;
        }
        System.out.println(B == A ? count : -1);
    }
}