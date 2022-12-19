package programmers.stack_queue_스택큐.P_프린터;
import java.util.*;

/** 성공 **/
public class P_프린터 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[] {2, 1, 3, 2}, 2); // 1
        solution.solution(new int[] {1, 1, 9, 1, 1, 1}, 0); // 5
    }
}

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Document> basicQueue = new LinkedList<>(); //순서가 그대로 들어가는 큐 (각 문서의 원래 인덱스를 기억하기 위해 Document 클래스 생성)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); //우선순위 큐

        for(int i = 0; i < priorities.length; i++)
        {
            Document d = new Document();
            d.priority = priorities[i];
            d.index = i;
            basicQueue.add(d);
            priorityQueue.add(priorities[i]);
        }

        int count = 0;

        while(!basicQueue.isEmpty()){
            Document d = basicQueue.poll();
            if(d.priority == priorityQueue.peek())
            {
                count++;
                priorityQueue.poll();
                if(d.index == location)
                    return count;
            }
            basicQueue.add(d);
        }

        return -1;
    }
    class Document implements Comparable<Document> {
        int priority;
        int index;

        @Override
        public int compareTo(Document d){
            return this.priority > d.priority ? 1 : -1;
        }
    }
}