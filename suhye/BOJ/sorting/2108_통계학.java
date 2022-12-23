import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 필요한 값: 수들의 합, 중앙 값, 최빈값(여러개라면 두번째로 작은 값), 최댓값과 최솟값
        // 카운팅 정렬 이용
        int[] arr = new int[8001];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[num + 4000]++;
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int count = 0; // 중앙값을 찾기 위해 갯수 카운트
        int arrMax = 0; // 최빈값을 찾기 위해 배열에서 가장 큰 값을 찾음
        // 중앙값과 최빈값은 -4000~4000을 제외한 수로 초기화
        int median = 5000; // 중앙값
        int mode = 5000; // 최빈값
        boolean flag = false; // 동일한 최빈값이 1번만 있었을 경우 true
        for(int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] > 0) {
                if (count < (N + 1) / 2) {
                    count += arr[i];
                    median = i - 4000;
                }
                if (arr[i] > arrMax) {
                    arrMax = arr[i];
                    mode = i - 4000;
                    flag = true;
                } else if (arr[i] == arrMax && flag) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }
        System.out.println((int)Math.round((double)sum / N));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max - min);

    }
}