import java.io.*;
import java.util.*;

public class 문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringTokenizer st = new StringTokenizer(br.readLine());    // 첫번째 입력 문자열 N, M

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> S = new HashSet<>();   // 문자열 N 담을 집합 S 선언
        int result = 0; // 집합 S에 포함되어있는 문자열 갯수

        for(int i = 0; i < N; i++) {    // 집합 S에 문자열 저장
            S.add(br.readLine());
        }

        for(int j = 0; j < M; j++) {
            if (S.contains(br.readLine())) {    // 집합 S에 입력 문자열 있으면 result 증가
                result++;
            }
        }

        bw.write(String.valueOf(result));   // 총 몇 개 출력

        bw.flush();
        bw.close();
        br.close();
    }
}