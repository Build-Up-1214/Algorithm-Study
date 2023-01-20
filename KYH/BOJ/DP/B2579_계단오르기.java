package baekjoon.dp_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 성공 **/
public class B2579_계단오르기 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int stairCtn = Integer.parseInt(bf.readLine());

        //문제에서 입력 조건이 300이하 이므로 미리 만들어 둬야함.
        //만약 입력 받는 계단 수로 생성을 하게 되면
        //계단 갯수가 1로 들어 왔을때 에러가 발생한다.
        int[] stair = new int[301];
        int[] sum = new int[301];

        for (int i = 1; i <= stairCtn; i++) {
            stair[i] = Integer.parseInt(bf.readLine());
        }

        //초기값을 미리 넣어놔야 점화식 부분에서 에러가 발생하지 않음
        //그리고 일종의 예외사항임
        //최초 시작인 0계단에서 1,2 계단을 밟을 수 있는 예외 사항으로 인해 미리 넣어 둠. 이후부터는 연달아 3개의 계단을 밟을 수 없기 때문에.
        sum[1] = stair[1];
        sum[2] = stair[1] + stair[2];

        for (int i = 3; i <= stairCtn; i++) {

            //핵심 점화식
            //n번째 계단은 어쨋든
            //n-2 번째 계단을 밟고 n번째 계단을 밟는 경우와
            //n-1 번째 계단을 밟고 n번째 계단을 밟는 경우가 있다
            //그러나 n-1 번째 계단을 밟고 n번째 계단을 밟는 경우는 n-2, n-1, n 번째 계단을 연달아 밟는 경우는 제외 시켜야 하기 때문에
            //더 디테일 하게 수식을 만들어야 한다.
            //n-2번째 계단을 밟지 않으면서 n-1번째 계단을 밟는 경우는 n-3번째를 밟고 n-1번째를 밟는 경우이기 때문에
            //더 상세하게 sum[i-3] + stair[i-1] + stair[i] 와 같이 수식을 만들어서, n-2번째를 밟고 n번째를 밟는 sum[i-2] + stair[i] 수식과 비교하여
            //더 큰 비용이 발생되는 방법을 선택하여 sum[i]에 저장하면 된다.
            sum[i] = Math.max(sum[i -2] + stair[i], sum[i - 3] + stair[i-1] + stair[i]);
        }

        System.out.println(sum[stairCtn]);
    }

}
