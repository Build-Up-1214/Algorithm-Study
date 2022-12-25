import java.io.*;
import java.util.*;

public class 나이순정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] s = new String[N];

        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }

        Arrays.sort(s, (s1, s2) -> {
            StringTokenizer st1 = new StringTokenizer(s1);
            StringTokenizer st2 = new StringTokenizer(s2);
            return Integer.parseInt(st1.nextToken()) - Integer.parseInt(st2.nextToken());
        });

        for (int i = 0; i < N; i++) {
            bw.write(s[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}