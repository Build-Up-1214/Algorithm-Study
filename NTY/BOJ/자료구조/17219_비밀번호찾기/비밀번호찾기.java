import java.util.*;
import java.io.*;

public class 비밀번호찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            hm.put(st.nextToken(), st.nextToken());
        }
        for (int i = 0; i < M; i++) bw.write(hm.get(br.readLine()) + '\n');
        br.close();
        bw.flush();
        bw.close();
    }
}