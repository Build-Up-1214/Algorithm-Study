package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공, Map 사용 **/
public class B10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Map<Integer,Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            Integer value = map.get(card);

            if(value != null)
                map.put(card, value+1);
            else
                map.put(card, 1);
        }

        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            Integer value = map.get(key);
            if(value != null)
                sb.append(value + " ");
            else
                sb.append("0 ");
        }

        System.out.println(sb);

    }
}
