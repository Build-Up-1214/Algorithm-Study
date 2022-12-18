import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> resultList = new ArrayList<>();

        // key: 장르, value: 재생 횟수 합
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 장르 우선순위로 장르를 정렬한 genreList
        List<Map.Entry<String, Integer>> genreList = new LinkedList<>(map.entrySet());
        genreList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));

        // 장르별 ArrayList 생성하여 각 list에 인덱스와 play 수 배열 형태로 넣기
        for (Map.Entry<String, Integer> entry : genreList) {
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(entry.getKey())) {
                    // arr[0]: 인덱스, arr[1]: 재생 횟수
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = plays[i];
                    list.add(arr);
                }
            }
            // 재생횟수 순으로 정렬
            list.sort(((o1, o2) -> o2[1] - o1[1]));
            // 정렬 후 0번째값 입력
            resultList.add(list.get(0)[0]);
            // 해당 장르 노래가 2개 이상이라면 한개 더 입력
            if (list.size() > 1) resultList.add(list.get(1)[0]);
        }

        int[] result = new int[resultList.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = resultList.get(i);
        }
        return result;

    }
}