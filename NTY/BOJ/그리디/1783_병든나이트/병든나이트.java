import java.util.*;
import java.io.*;

public class 병든나이트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max;
        if(N == 1) max = 1;
        else if(N == 2) {
            if(M < 7) max = (M + 1) / 2;
            else max = 4;
        } else {
             if(M < 5) max = M;
             else if(M < 7) max = 4;
             else max = 5 + (M - 7);
        }

        System.out.println(max);
    }
}