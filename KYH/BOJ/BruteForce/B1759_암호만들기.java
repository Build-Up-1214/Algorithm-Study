package baekjoon.brute_force_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공 **/
public class B1759_암호만들기 {

    static Map<String, String> mMap = new HashMap<>();
    static int l, c;
    static StringBuilder sb = new StringBuilder();
    static String[] input;
    static {
        mMap.put("a","a");
        mMap.put("e","e");
        mMap.put("i","i");
        mMap.put("o","o");
        mMap.put("u","u");
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        input = new String[c];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < c; i++) {
            input[i] = st.nextToken();
        }

        Arrays.sort(input);
        makePassword(0, new ArrayList<>());

        System.out.println(sb);
    }

    private static void makePassword(int depth, List<String> list) {

        if (list.size() == l) {
            int mCtn = 0;
            for (int i = 0; i < list.size(); i++) {
                if(mMap.get(list.get(i)) != null)
                    mCtn++;
            }

            if(mCtn >= 1 && (l - mCtn) >= 2)
            {
                list.forEach(s->sb.append(s));
                sb.append("\n");
            }
            return;
        }


        for (int i = depth; i < c; i++) {
            List<String> copy = new ArrayList<>(list);
            copy.add(input[i]);
            makePassword(i+1, copy);
        }
    }
}
