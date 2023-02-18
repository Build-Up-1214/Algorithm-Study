import java.io.*;
import java.util.*;

public class 패션왕신해빈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Map<String, Integer> hm = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                hm.put(kind, hm.getOrDefault(kind,1) + 1);  // 기본값 1과 추가 값에 없는 경우의 수 추가
            }
            int count = 1;
            for (int n : hm.values()) count *= n;
            sb.append(count - 1).append('\n');  // 아무것도 안 선택할 경우 제외 -1
        }
        System.out.print(sb);
    }
}