package baekjoon.sort_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 성공 **/
public class B2587_대표값2 {
    static int size = 5;
    static int maxValue = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        selectSort(arr);

    }

    /** 성공 **/
    private static void selectSort(int[] arr) {

        int sum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length-1; i++) {

            int curMinIdx = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[curMinIdx] < arr[j]) {
                    curMinIdx = j;
                }
            }

            if (curMinIdx != i) {
                int temp = arr[curMinIdx];
                arr[curMinIdx] = arr[i];
                arr[i] = temp;
            }
        }

        System.out.println(sum / size);
        System.out.println(arr[2]);
    }

}
