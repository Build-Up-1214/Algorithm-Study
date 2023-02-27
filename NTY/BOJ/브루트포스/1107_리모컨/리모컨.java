import java.util.*;
import java.io.*;

public class 리모컨 {
    /*
    타겟 채널을 한자리씩 비교하면서 근접한 수를 찾는 방법은 예외가 많아짐.. -> 코드가 길어짐
    0번부터 번호누를 수 있는 채널을 비교 대상(100번에서 +-)과 최소 경우 찾는 경우로 해결
     */
    private static boolean[] remote = new boolean[10];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(remote, true);
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) remote[Integer.parseInt(st.nextToken())] = false;
        }

        int min = Math.abs(N - 100);    // 100번에서 +- 이용해서 채널이동
        for (int i = 0; i < 999999; i++) {  // 0번 부터 999999(100번에서 이동하는 최악의 경우 근접 값)
            if(check(i)) {  // 번호 누를 수 있는 지 체크
                min = Math.min(Math.abs(i - N) + String.valueOf(i).length(), min);
                if(i == N) break;   // 만약 타겟 채널과 같으면 루프 종료 -> 누르는 경우 최소
            }
        }

        System.out.println(min);
    }

    private static boolean check(int ch) {
        if(ch == 0) {
            return remote[ch];
        } else {
            while (ch > 0) {
                if(!remote[ch % 10]) return false;  // 1의 자리 수부터 번호 누를 수 있는지 체크
                else ch /= 10;
            }
        }
        return true;
    }
}