package baekjoon.greedy_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공, 제출 **/
public class B13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] dis = new int[n-1];
        int[] price = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n-1; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        //현재까지의 리터당 최소가격, sum과 함께 long 타입으로 해주어야 한다.
        //그렇지 않으면 아래에서 dis[0]과 min 모두 int 형이기 때문에, dis[0] * min 의 결과는 임시로 int에 담겨 오버플로우가 발생되고
        //발생된 값이 long에 담기는것이므로 sum만 long 타입인건 의미가 없다.
        long min = price[0];
        long sum = dis[0] * min; //거리의 크기는 최대 1000000000 이므로, 리터당 가격과 곱셈이 이루어지면 int의 범위인 20억은 가뿐히 넘는다
        for (int i = 1; i < n-1; i++) {
            if (min > price[i]) {
                min = price[i];
            }

            sum += dis[i] * min;
        }

        System.out.println(sum);
    }
}
