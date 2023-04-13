package baekjoon.stack_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/** 성공 **/
public class B10773_제로 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(bf.readLine());

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            int value = Integer.parseInt(bf.readLine());
            if(value == 0)
                list.remove(list.size()-1);
            else
                list.add(value);
        }

        System.out.println(list.stream().mapToInt(i -> i).sum());
    }
}
