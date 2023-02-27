import java.io.*;
import java.util.*;

public class Z {
    /*
    1 ≤ N ≤ 15 -> 배열로 전체 찾아서 하면 메모리와 시간초과발생
     */
    private static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        where(r, c, (int)Math.pow(2, N));
        System.out.println(count);
    }

    private static void where(int r, int c, int n) {
        if(n > 1) {
            n /= 2;
            if(r < n && c < n) where(r, c, n);  // 1사분면
            else if(r < n && c >= n) {  // 2사분면
                where(r, c - n, n);
                count += n * n;
            }
            else if(r >= n / 2 && c < n) {  // 2사분면
                where(r - n, c, n);
                count += 2 * n * n;
            }
            else {  // 3사분면
                where(r - n, c - n, n);
                count += 3 * n * n;
            }
        }
    }

}