import java.util.*;
class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int half = nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.size() < half) set.add(n);
            else if(set.size() == half) return half;
        }
        return set.size();
    }
}