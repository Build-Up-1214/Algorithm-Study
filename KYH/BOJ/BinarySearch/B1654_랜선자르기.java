package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B1654_랜선자르기 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] line = new long[k];


        long max = 0;
        for (int i = 0; i < k; i++) {

            line[i] = Integer.parseInt(bf.readLine());
            if(line[i] > max)
                max = line[i];
        }


        long mid = 0;
        long left = 1;
        long right = max;

        while (left <= right) {

            mid = (left + right) / 2;

            int ctn = 0;
            for (int i = 0; i < line.length; i++) {

                ctn += line[i] / mid;
            }

            //ctn == n인 순간 break로 탐색을 중지 하는것이 아니라
            //혹시 더 큰 길이가 가능한지 끝까지 찾는것이 핵심
            if (ctn < n) {
                right = mid - 1;
            }
            else {
                //n에 충족하는것을 찾고나서도
                //혹시 더 큰 길이(mid)가 가능한지 left 범위를 좁힘
                left = mid + 1;
            }
        }

        //mid가 n과 같아지는 조건에 한번 충족한 이후로는 left의 범위를 좁힌 뒤
        //결국 마지막에는 if (ctn < n) 조건에 들어가게 될 것이기 때문에 right를 써줘야함
        System.out.println(right);
    }
}
