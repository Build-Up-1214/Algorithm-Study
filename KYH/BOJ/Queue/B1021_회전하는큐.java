package baekjoon.queue_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 성공, 제출 **/
public class B1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] removeArr = new int[m];
        int removeIdx = 0;
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < m; i++) {
            removeArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int totalCtn = 0; //덱의 총 조작 횟수 (결과값)
        while (removeIdx < m) { //총 제거해야하는 요소가 남은 경우 계속 반복

            Iterator<Integer> iterator = deque.iterator();
            int ctn = 0;
            while (iterator.hasNext()) { //다음 제거 요소가 몇번째 인덱스에 존재하는지 확인
                int next = iterator.next();
                if (next == removeArr[removeIdx]) {
                    break;
                }
                ctn++;
            }



            int diff = deque.size() - ctn;
            if (ctn <= diff) { //만약 제거 요소의 위치가 왼쪽에서 뺄떄 더 최소의 연산인 경우. 왼쪽 오른쪽 기준 중간에 위치에 있더라도 왼쪽이 한단계 더 빠르다... 그러므로 <=
                totalCtn += ctn;
                while (ctn > 0) {
                    deque.offerLast(deque.pollFirst());
                    ctn--;
                }

            } else { //만약 제거 요소의 위치가 오른쪽에서 뺄떄 더 최소의 연산인 경우
                totalCtn += diff;
                while (diff > 0) {
                    deque.offerFirst(deque.pollLast());
                    diff--;
                }

            }

            deque.poll();
            removeIdx++; //하나 제거 됬으므로 다음 제거 요소 인덱스로 증가
        }

        System.out.println(totalCtn);
    }
}
