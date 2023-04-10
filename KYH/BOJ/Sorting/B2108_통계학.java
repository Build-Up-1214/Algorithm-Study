package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공 **/
public class B2108_통계학 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        System.out.println(getAvg(arr));
        System.out.println(getCenter(arr));
        System.out.println(getRepeat(arr));
        System.out.println(getRange(arr));
    }

    static int getAvg(int[] input) {
        return Math.round((float)Arrays.stream(input).sum() / (float)input.length);
    }

    static int getCenter(int[] input) {
        Arrays.sort(input);

        return input[input.length/2];
    }

    static int getRepeat(int[] input) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            Integer ctn = map.get(input[i]);

            if (ctn == null) {
                map.put(input[i], 1);
            } else {
                map.put(input[i], ctn+1);
            }
        }

        int maxRepeatKey = input[0];
        Set<Integer> keySet = map.keySet();

        for (Integer key : keySet) {
            if (map.get(maxRepeatKey) < map.get(key)) {
                maxRepeatKey = key;
            }
        }

        List<Integer> list = new LinkedList<>();

        for (Integer key : keySet) {

            if (map.get(maxRepeatKey) == map.get(key)) {
                list.add(key);
            }
        }

        Collections.sort(list);

        if (list.size() > 1) {
            return list.get(1);
        } else {
            return list.get(0);
        }
    }

    static int getRange(int[] input) {

        return input[input.length-1] - input[0];
    }

}
