package baekjoon.queue_큐.B12873_기념품;//package baekjoon.queue_큐.B12873_기념품;


import java.util.*;

/** 성공 **/
public class B12873_기념품 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution.solution(scanner.nextInt()));
    }
}

class Solution{
    public int solution(int n) {
        Queue<Integer> circle = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        int level = 1;

        while (circle.size() > 1) {

            //5000까지 들어 올 수 있는 n으로 인해 4999의 3승 계산을 해야하므로 하므로 int 범위를 벗어나게 된다.
            //그로 인해 n이 5000일 경우에도 잘못된 값이 나오게 되므로, 반드시 long으로 해야한다!
            long aroundCtn = (long)Math.pow(level, 3);

            long aroundCtnOfOneCircle = aroundCtn % circle.size();

            //0번 외친다는 개념은 문제상 존재하지 않는다.
            //그러나 for문 의 반복을 줄이기 위해 현위 위치에서 한 바퀴 이내의 외침 횟수를 구하기 위해
            //나머지 연산을 하므로, 0이란 값이 존재할 수가 있는것이다.
            //그럴 경우, 현재 위치를 시작점으로 봤을때 가장 끝에 있는 멤버 위치에서 외치는 것이므로,
            //인원 수 만큼을 잡고, 가장 끝에 있는 멤버들은 큐에 다시 넣고 마지막 멤버를 제외시키면 된다.
            if(aroundCtnOfOneCircle == 0)
                aroundCtnOfOneCircle = circle.size();

            if (aroundCtnOfOneCircle > 1) {

                for (int i = 0; i < aroundCtnOfOneCircle-1; i++) {
                    Integer number = circle.poll();
                    circle.add(number);
                }
            }

            //나머지가 1인 경우는 현재 위치에서 순번을 1번 외친다는 의미이다.
            //그러므로 현재 위치의 멤버 앞에서 순번을 외치고 해당 멤버를 제외시킨다.
            circle.poll();
            level++;
        }

        return circle.poll();
    }
}