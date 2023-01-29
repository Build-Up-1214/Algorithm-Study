package baekjoon.binary_이진검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        long[] trees = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(max < trees[i])
                max = trees[i];
        }


        //하나도 안 잘라도 되는 경우도 있을 수 있기 때문에 최소 범위를 0부터 시작
        long left = 0;
        long right = max;
        while (left <= right) {

            long mid = (left+right) / 2;

            long sum = 0;
            for (int i = 0; i < trees.length; i++) {
                long diff = trees[i] - mid;
                sum += diff < 0 ? 0 : diff;
            }

            //정확하게 m과 일치하는 sum이 나오지 않는 경우가 있을 수 있다.
            //그렇기 때문에 sum == m 으로 해당 루프를 break 시켜선 안된다.
            //그리고 m과 일치하는 sum이 나오는 경우가 있을 수 있다.
            //이 경우에서는 left를 mid + 1로 높이를 올려보고
            //이후부턴 m보다 적은 sum이 나올것이기 때문에
            //계속 right가 mid - 1로 좁혀질 것이다
            //계속좁혀지다가 결국 mid와 left가 같아 지는 상황이 발생할 것이다. ( 16 ~ 17 (16+17) 의 mid는 16)
            //그런데도 m이 sum보다 적게 나올 것이기 때문에
            //결국 right는 left보다 작아지는 상황이 발생하고 left - 1 이 최초에 sum과 m이 일치했던 상황이기 때문에
            //right과 최적의 높이가 된다.
            if(sum >= m)
            {
                left = mid + 1;

            }
            else
            {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
