package baekjoon.sort_정렬;

import java.util.Arrays;
import java.util.Scanner;

/** 성공 **/
public class B1246_온라인_판매 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] price = new int[m];

        for (int i = 0; i < m; i++) {
            price[i] = scanner.nextInt();
        }

        Arrays.sort(price);

        int maxMoney = 0;
        int eggMoney= 0;

        for (int i = 0; i < price.length; i++) {

            int curMaxMoney = 0;
            int curEggMoney = price[i]; //만약 i번째 인원이 선언한 구매금액으로, 임시로 개당 계란 판매 금액을 세팅
            if((m-i) < n) //현재 금액으로 살 수 있는 인원 < 계란 갯수
            {
                curMaxMoney = (m-i) * curEggMoney; //살 수 있는 인원 * 현재 임시로 세팅된 개당 계란 가격 => 총 수입 금액
            }
            else //현재 금액으로 살 수 있는 인원 < 계란 갯수, 살 수 있는 인원이 많아도 계란이 애초에 부족.
            {
                curMaxMoney = n * curEggMoney; //계란 갯수만큼만 판매 가능 하기 때문에, 계란 갯수 * 임시로 세팅된 개당 계란 금액
            }
            if (curMaxMoney > maxMoney) { //예상 수익금이 지금까지 구해 본 최대 수익금 보다 클 경우
                maxMoney = curMaxMoney;
                eggMoney = curEggMoney;
            }
        }
        System.out.println(eggMoney + " " + maxMoney);
    }
}
