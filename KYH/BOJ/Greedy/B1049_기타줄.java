package baekjoon.greedy_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 성공 **/
public class B1049_기타줄 {
    public static void main(String[] args) throws IOException {

        //기본 컨셉
        //필요한 n개의 기타줄 내에서 가격을 고려하여 브랜드별로 따로 구매할 수 있다.
        //즉, n이 7이고 A 브랜드는 6개의 패키지 가격이 6원이다 그러나 낱개는 개당 3원이다.
        //하지만, B브랜드는 6개의 패키지 가격이 8원인 대신에 개당 2원이다.
        //그러면 A브랜드에서 6개 패키지 1개 사고 B브랜드에서 낱개로 1개를 사면 가장 저렴하게 구매 가능

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pk = new int[m];
        int[] se = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            pk[i] = Integer.parseInt(st.nextToken());
            se[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pk); //패키지별 가격 오름차순
        Arrays.sort(se); //낱개별 가격 오름차순

        if (se[0] * 6 < pk[0]) { //낱개로 사는게 차라리 쌀 경우
            System.out.println(n * se[0]);
            return;
        } else { //6개 단위는 그래도 패키지로 사는게 싼 경우
            int pkPrice = ((n/6) * pk[0]); //우선 패키지로 n개의 기타줄을 최대한 사보고
            int sePrice = (n%6) * se[0]; //6개 미만의 나머지 기타줄을 낱개 가격으로 삼

            if (sePrice > pk[0]) { //혹시 나머지 낱개를 낱개 가격으로 산것보다 차라리 패키지로 사는것이 싼 경우
                sePrice = pk[0];
            }
            System.out.println(pkPrice + sePrice);
        }

    }
}
