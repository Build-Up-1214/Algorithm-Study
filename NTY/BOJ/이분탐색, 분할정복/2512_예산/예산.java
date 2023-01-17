import java.io.*;
import java.util.*;

public class 예산 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        Arrays.sort(arr);   // 정렬

        int max = 0;
        int M = Integer.parseInt(br.readLine());

        // 조건 1 그대로 배정
        if (sum <= M) {
            max = arr[arr.length - 1];
        }
        // 조건 2 상한액 배정
        else {
            int low = 0;
            int high = M;
            while (low <= high) {
                int mid = (low + high) / 2;
                int checkSum = 0;
                int over = 0;
                for (int i : arr) {
                    if (i > mid) {
                        checkSum += mid;
                        over++;
                    }
                    else checkSum += i;
                }
                if (Math.abs(checkSum - M) < over) {
                    max = mid;
                    break;
                }
                else if (checkSum < M) low = mid + 1;
                else high = mid - 1;    // checkSum > M
            }
        }
        System.out.println(max);
    }
}