import java.io.*;
import java.util.*;

public class 생태학 {
    public static void main(String[] args) throws Exception {
        /*
            map -> set 변환 후
            정렬, 값 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hm = new HashMap<>();

        int count = 0;
        while (true) {
            String tree = br.readLine();
            if (tree == null || tree.length() == 0) break;
            if (hm.containsKey(tree)) hm.put(tree, hm.get(tree) + 1);
            else hm.put(tree, 1);
            count++;
        }

        final int total = count;
        hm.entrySet().stream()
                .sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
                .forEach(e -> sb.append(e.getKey()).append(" ").append(String.format("%.4f", e.getValue()*100.0/total)).append("\n"));

        System.out.println(sb);
        br.close();
    }
}