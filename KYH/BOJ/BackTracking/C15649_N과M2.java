package baekjoon.backtracking_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공 **/
public class C15649_N과M2 {

    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {

            List<Integer> list = new ArrayList<>();
            list.add(i);
            recursion(list, i);
        }
    }

    private static void recursion(List<Integer> list, int curValue) {

        if(list.size() == m)
        {
            list.stream().forEach(i-> System.out.print(i + " "));
            System.out.println();
            return;
        }

        for (int i = curValue + 1; i <= n; i++) {

            List<Integer> newList = new ArrayList<>(list);
            newList.add(i);
            recursion(newList, i);
        }

    }
}
