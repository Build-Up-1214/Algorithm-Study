import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        /*
        ArrayList 사용시 시간초과
        HashSet의 contains()는 O(1), ArrayList의 contains()는 O(n)이다.
        HashSet은 map을 기반으로 구현되고, ArrayList는 indexOf()를 사용해서 contain여부를 결정
        */
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if(set.contains(name)) {
                result.add(name);
            }
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size() + "\n");
        for (String s : result) {
            sb.append(s + "\n");
        }
        System.out.print(sb);
    }
}