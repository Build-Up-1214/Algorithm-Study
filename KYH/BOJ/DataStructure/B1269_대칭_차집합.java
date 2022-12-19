package baekjoon.hash_해시;

import java.util.*;

///** 성공, 해시맵을 사용한 풀이 **/
//public class B1269_대칭_차집합 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int aCount = scanner.nextInt();
//        int bCount = scanner.nextInt();
//
//        List<Integer> list = new ArrayList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int totalCount = aCount + bCount;
//
//        for (int i = 0; i < totalCount; i++) {
//            list.add(scanner.nextInt());
//        }
//
//        for (Integer i : list) {
//            Integer value = map.get(i);
//
//            if(value == null)
//                map.put(i, 1);
//            else
//                map.put(i,value+1);
//        }
//
//        int count = 0;
//        for (Integer key : map.keySet()) {
//            if(map.get(key) == 1)
//                count++;
//        }
//        System.out.println(count);
//    }
//}

/** 성공, 해시맵 사용한 풀이2 **/
public class B1269_대칭_차집합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int aCount = scanner.nextInt();
        int bCount = scanner.nextInt();

        HashMap<Integer,Integer> map = new HashMap<>();

        int totalCount = aCount + bCount;

        for (int i = 0; i < totalCount; i++) {
            int input = scanner.nextInt();
            if (map.get(input) == null) {
                map.put(input,1);
            }
            else {
                map.remove(input);
            }
        }
        System.out.println(map.size());
    }
}