package baekjoon.sort_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B24051_알고리즘_수업_삽입_정렬1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        insertSort(arr, k);
    }

    public static void insertSort(long[] arr, int k) {

        int count = 0;

        for (int i = 1; i < arr.length; i++) {

            int loc = i - 1; //이미 정렬이 되었다고 가정한 범위의 인덱스. 삽입 차례의 인덱스-1 로 시작해서 0이 될때까지.
            long newItem = arr[i]; //이번에 삽입될지도 모르는 삽입 대상의 값

            while (loc >= 0 && newItem < arr[loc]) { //정렬 되었다 가정한 범위를 조회 하는 인덱스가 0이거나 0보다 클때 && 삽입대상이 정렬 범위의 값(loc위치) 보다 작은 경우

                //뒤로 한칸 밀려서 할당하는것 자체가 count 증가
                count++;
                arr[loc + 1] = arr[loc];
                if (count == k) {
                    System.out.println(arr[loc + 1]);
                    return;
                }
                loc--;
            }

            if (loc + 1 != i) {

                //앞서서 뒤로 한칸씩 민 다음에 삽입 대상이 본인의 자리를 찾아 들어갈때도 count 증가
                count++;
                arr[loc + 1] = newItem;
                if (count == k) {
                    System.out.println(arr[loc + 1]);
                    return;
                }

            }
        }


        System.out.println(-1);
    }
}
