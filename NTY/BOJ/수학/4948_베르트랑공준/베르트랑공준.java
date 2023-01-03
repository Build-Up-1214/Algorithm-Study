import java.io.*;

public class 베르트랑공준 {
    private static boolean[] prime = new boolean[123456 * 2 + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init(); // 입력 최대값 케이스 기준 모든 소수 구하기

        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input == 0) break;   // 0이면 종료
            sb.append(counter(input)).append("\n"); //  입력(제한된 범위) 내에서 소수 구하기
        }

        System.out.println(sb);
        br.close();
    }

    private static int counter(int n) {
        int count = 0;
        for (int i = n + 1; i <= 2 * n; i++) {
            if(!prime[i]) count++;
        }
        return count;
    }

    private static void init() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(123456 * 2); i++) {
            if(prime[i]) continue;
            for (int j = i * i; j <= 123456 * 2; j = j + i) {
                prime[j] = true;
            }
        }
    }
}