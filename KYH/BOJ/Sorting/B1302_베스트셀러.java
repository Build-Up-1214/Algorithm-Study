package baekjoon.sort_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class B1302_베스트셀러 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String bookTitle = bf.readLine();
            Integer count = hashMap.get(bookTitle);
            if(count == null)
                hashMap.put(bookTitle, 1);
            else
                hashMap.put(bookTitle, count+1);
        }

        int max = 0;
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            Integer count = hashMap.get(key);
            if (count > max) {
                max = count;
            }
        }

        List<String> titleList = new LinkedList<>(keySet);
        Collections.sort(titleList);

        for (String key : titleList) {
            if (hashMap.get(key) == max) {
                System.out.println(key);
                return;
            }
        }
    }
}
