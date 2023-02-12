package baekjoon.greedy_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 성공 **/
public class B1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        //우선 -으로 파싱함
        String[] values = input.split("-");

        //-으로 파싱했을때, 첫번째 항은 무조건 합에 포함되는 값이므로
        //첫번째 항을 +기준으로 다시 파싱하여 정수들만 걸러냄
        String[] bases = values[0].split("\\+");

        //-으로 파싱한 항들 중 첫번째 항의 모든 정수값들을 합해서 결과값(sum)에 합함
        int sum = Arrays.stream(bases).mapToInt(i-> Integer.parseInt(i)).sum();

        //-으로 파싱한 항들 중 첫번째 항을 제외한 나머지 항들은 모두 -될 값들이기 때문에 정수만 걸러내서 합한 뒤 sum에서 차감함.
        //만약 식에 -가 없다고 하여도 항은 1개이기 때문에 아래 for문 자체를 들어가지 않음.
        for (int i = 1; i < values.length; i++) {
            String[] split = values[i].split("\\+");
            sum -= Arrays.stream(split).mapToInt(j->Integer.parseInt(j)).sum();
        }

        System.out.println(sum);
    }
}
