package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];

        int idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int goodCtn = 0;

        for(int i = 0; i<arr.length; i++) {
            int findNumber = arr[i];

            int start = 0;
            int end = arr.length - 1;
            int sum = 0;


            while(start < end){
                sum = arr[start] + arr[end];
                if(sum == findNumber){
                    if(i == start)
                        start++;
                    else if(end == i)
                        end--;
                    else{
                        goodCtn++;
                        break;
                    }
                }

                if(arr[start] + arr[end] > findNumber)
                    end--;
                else if(arr[start] + arr[end] < findNumber)
                    start++;
            }
        }
        System.out.println(goodCtn);
    }
}
