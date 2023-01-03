import java.io.*;
import java.util.*;

public class 소수구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        /*
            √N 이하의 자연수들로 모두 나누기
            시간복잡도: O(N√N)
         */
//        for (int i = M; i <= N; i++) {
//            if(i < 2) continue;
//            if(i == 2 || i == 3) {
//                sb.append(i).append("\n");
//                continue;
//            }
//            for (int j = 2; j <= Math.sqrt(i); j++) {
//                if (i % j == 0) break;
//                if (j == (int)Math.sqrt(i)) sb.append(i).append("\n");
//            }
//        }

        /*
            에라토스테네스의 체: k=2 부터 √N 이하까지 반복하여 자연수들 중 k를 제외한 k의 배수들을 제외
            시간복잡도: O(N㏒(㏒N))
            이 방법이 엄청 빠르다(1억이하 모든 소수 구하는데도 몇 초 밖에 안걸림)
         */
        boolean[] prime = new boolean[N + 1];   // 소수 확인 배열
        prime[0] = prime[1] = true; // true -> 소수가 아님

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i]) { // 소수가 아니면 패스
                continue;
            }
            // i 소수인 상태
            for (int j = i * i; j <= N; j += i) {   // i의 제곱수를 시작으로 i만큼 증가하는 수는 소수가 아니므로 소수아님(true) 체크
                prime[j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}

