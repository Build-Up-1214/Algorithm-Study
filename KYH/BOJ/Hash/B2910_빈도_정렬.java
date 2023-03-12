package baekjoon.hash_해시;


import java.util.*;


/** 제출 **/
public class B2910_빈도_정렬 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long c = scanner.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();


        //빈도수 저장 부분
        for (int i = 0; i < n; i++) {
            Integer input = scanner.nextInt();
            Integer value = map.get(input);

            if(value == null) { // 맵에 존재하지 않다면, 처음 입력된 키

                map.put(input, 1); //빈도수 초기화
            }
            else { //이미 한번 입력된 키일 경우
                map.put(input, value+1); //빈도수 증가
            }
        }

        List<Integer> result = new ArrayList<>(map.keySet());

        //빈도 수 기준으로 리스트 정렬
        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return Integer.compare(map.get(o1).intValue(), map.get(o2).intValue());
            }
        });

        Iterator<Integer> it = result.iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            for(int i=0; i<map.get(element); i++){
                System.out.print(element+" ");
            }

        }
    }
}






//public class B2910_빈도_정렬 {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        long c = scanner.nextInt();
//
//        HashMap<Long, Long> map = new HashMap<>();
//        List<Long> result = new ArrayList<>();
//
//        //빈도수 저장 부분
//        for (int i = 0; i < n; i++) {
//            long input = scanner.nextInt();
//            Long value = map.get(input);
//
//            if(value == null) { // 맵에 존재하지 않다면, 처음 입력된 키
//                result.add(input);
//                map.put(input, 1L); //빈도수 초기화
//            }
//            else { //이미 한번 입력된 키일 경우
//                map.put(input, value+1); //빈도수 증가
//            }
//        }
//
//        //빈도 수 기준으로 리스트 정렬
//        Collections.sort(result, new Comparator<Long>() {
//            @Override
//            public int compare(Long o1, Long o2) {
//
//                return map.get(o1) > map.get(o2) ? -1 : 1;
//            }
//        });
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < result.size(); i++) {
//
//            for (int j = 0; j < map.get(result.get(i)); j++) {
//
//                sb.append(result.get(i)+ " ");
//            }
//        }
//
//        sb.deleteCharAt(sb.length()-1);
//
//        System.out.println(sb);
//    }
//}

