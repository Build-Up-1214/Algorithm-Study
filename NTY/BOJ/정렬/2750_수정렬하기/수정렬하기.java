
import java.io.*;

public class 수정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력
        StringBuilder sb = new StringBuilder(); // 출력

        int N = Integer.parseInt(br.readLine());    // 명령어 수

        /**
         * 카운팅 정렬(Counting Sort)활용, 입력값 (-1000 ≤ N ≤ 1,000) 범위와 같이 수의 범위가 제한적일 때 효율이 좋다(메모리 낭비 유발)
         * 대부분 퀵정렬(Quick Sort)이 좋다(퀵정렬의 경우 시간복잡도 평균값이 𝚶(nlogn)으로 빠른편이면서 배열도 하나만 사용하기 때문에 공간복잡도는 𝚶(𝑛) 으로 시간과 메모리 둘 다 효율적이라는 점)
         *
         * range : -1000 ~ 1000
         * index[1000] = 0
         */

        boolean[] arr = new boolean[2001];  // 입력값 범위 만큼의 크기를 갖는 boolean 배열 선언

        for(int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000] = true;    // 입력값 index에 true
        }

        for(int i = 0; i < 2001; i++) {
            if(arr[i]) {
                sb.append(i - 1000).append("\n");  // true인 인덱스 출력
            }
        }

        System.out.println(sb);

        /**
         * 삽입정렬, Array.sort()정렬 방법

         for (int i = 0; i < N; i++) {
         arr[i] = Integer.parseInt(br.readLine());
         }

         Arrays.sort(arr);   // Arrays.sort -> O(nlogn)

         for (int i = 0; i < N - 1; i++) {   // 선택정렬(Selection Sort) -> O(n^2)
         for (int j = i + 1; j < N; j++) {
         if(arr[i] > arr[j]){
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
         }
         }
         }
         */
    }
}