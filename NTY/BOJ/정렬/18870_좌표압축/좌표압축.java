import java.io.*;
import java.util.*;

public class 좌표압축 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] X = new int[N];
        int[] X_1 = new int[N];
        HashMap<Integer, Integer> hm = new HashMap<>(); // (값, 정렬 후 순서(0부터 시작)) 형태로 HashMap 저장
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            X[i] = Integer.parseInt(s); // 기존 입력 순서 저장
            X_1[i] = Integer.parseInt(s);   // 정렬 후 순서 저장
        }

        Arrays.sort(X_1);   // 정렬

        int index = 0;  // 중복 무시하고 넣을 인덱스값(순서)

        for (int i = 0; i < N; i++) {
            if(!hm.containsKey(X_1[i])){    // 키캆으로 없으면(중복 제거)
                hm.put(X_1[i], index);  //(값, 정렬 후 순서(0부터 시작))
                index++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(hm.get(X[i])).append(" ");
        }

        System.out.println(sb);
    }
}