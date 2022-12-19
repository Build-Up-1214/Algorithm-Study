import java.util.*;
import java.io.*;

public class 요세푸스문제 {
    /**
     * 인덱스 n번째 -> 인덱스 범위 초과 시 증가 후 %로 찾는다
     * 삭제고려 LinkedList 사용 -> 크기, 삭제 빈도가 많을수록 ArrayList 보다 좋다
     * 이 문제에선 ArrayList 가 좀 더 빠르게 나오는거 같다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());    // N, K 구분
        StringBuilder sb = new StringBuilder(); // 출력

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> linkedList = new LinkedList<>();    // 1 ~ N 담을 리스트

        for(int i = 1; i <= N; i++){
            linkedList.add(i);  // 값 저장
        }

        int index = K - 1;  // 초기 인덱스

        sb.append("<"); // 출력값

        while(!linkedList.isEmpty()){
            index = index % linkedList.size();  // 인덱스가 리스트 크기 보다 클 때를 위해 리스트 크기만큼 나눠서 인덱스 값 대입
            sb.append(linkedList.remove(index));    // 해당 인덱스 값 삭제 및 출력
            if(!linkedList.isEmpty()) sb.append(", ");  // 마지막 값 아니면 출력에 ", " 포함
            else sb.append(">");    // 마지막 값이면 출력에 ">"
            index = index + K - 1;  // 인덱스 값 증가(K만큼 증가하고 이전 삭제로 인덱스값 -1)
        }

        System.out.println(sb); // 출력
    }
}