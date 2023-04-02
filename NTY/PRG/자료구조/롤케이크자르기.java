import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int n : topping) map2.merge(n, 1, Integer::sum);

        for (int i = 0; i < topping.length; i++) {
            Integer num = topping[i];

            map1.merge(num, 1, Integer::sum);
            if (map2.get(num) <= 1) map2.remove(num);
            else map2.merge(num, -1, Integer::sum);

            if (map1.size() == map2.size()) answer++;
        }
        return answer;
    }
}