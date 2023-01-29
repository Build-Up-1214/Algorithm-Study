package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2473_세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        long min = Long.MAX_VALUE;
        long[] result = new long[3];

        //해당 for문으로 left의 값, 즉 하나의 값은 고정을 한 뒤 두포인터를 진행시켜야 한다
        //그렇지 않고 while문으로만 하려고 하면
        //-24, -6, -3, -2 61, 98, 100 과 같은 상황에서 -6,-3,-2 가 결과값으로 도출될 수 없다
        for (int i = 0; i < n - 2; i++) {
            int left = i;
            int mid = i+1;
            int right = n-1;

            while (mid < right) {

                //arr배열도 long타입으로 해야 함.
                //그렇지 않으면, 1000000000 999999999 999999998 999999997가 들어 왔을 떼, 즉, 용액의 최대값이 들어왔을 때
                //int형들끼리 계산을 하였으므로, arr[left] + arr[mid] + arr[right]의 결과가 int 타입의 임시 변수에 담기고 long에 저장이 된다.
                //즉, 이미 오버플로우가 발생되고 long 담기므로, sum만 long이면 소용이 없다.
                long sum = arr[left] + arr[mid] + arr[right];
                long absSum = Math.abs(sum);
                if (absSum < min) {
                    min = absSum;
                    result[0] = arr[left];
                    result[1] = arr[mid];
                    result[2] = arr[right];
                }

                if (sum > 0) {
                    right--;
                } else if(sum == 0){
                    break;
                }
                else{
                    mid++;
                }
            }
        }


        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
