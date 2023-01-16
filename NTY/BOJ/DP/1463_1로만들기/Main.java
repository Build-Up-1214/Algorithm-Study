import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(F(N,0));
        br.close();
    }

    private static int F(int x, int count) {
        if(x <= 1){     // 나누었을 때 몫이 1 이하 이면
            return count;   // 카운트 반환
        }
        // 2 와 3을 나누면서 모든 케이스별로 분리 후, 최소 카운트 반환
        return Math.min(F(x / 2, count + 1 + x % 2), F(x / 3, count + 1 + x % 3));
    }
}