import java.io.*;

public class NQueen {
    private static int N, count = 0;
    private static int[] column;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        column = new int[N];
        check(0);
        System.out.println(count);
    }

    private static void check(int d) {
        if(d == N) count++;
        else {
            for (int i = 0; i < N; i++) {   // n 행에서 놓을 수 있는 경우 체크
                if(isOk(d, i)){
                    column[d] = i;
                    check(d + 1);
                }
            }
        }
    }
    // 체스 놓을 수 있는지 체크
    private static boolean isOk(int r, int c) {
        for (int i = 0; i < r; i++) {
            if(column[i] == c) return false;    // 같은 열에 있는 경우 체크
            if(Math.abs(i - r) == Math.abs(column[i] - c)) return false;    // 대각선에 있는 경우 체크
        }
        return true;
    }
}