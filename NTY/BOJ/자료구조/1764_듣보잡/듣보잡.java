import java.io.*;
import java.util.*;

public class 듣보잡 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> hs = new HashSet<>();
        ArrayList<String> al = new ArrayList();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) hs.add(br.readLine());

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (hs.contains(s)) al.add(s);
        }

        Collections.sort(al);

        sb.append(al.size()).append("\n");
        for (String s : al) sb.append(s).append("\n");

        System.out.println(sb);
    }
}