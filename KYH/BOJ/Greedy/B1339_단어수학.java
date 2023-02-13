package baekjoon.greedy_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 성공 **/
class B1339_단어수학{
    public static void main(String[] args) throws IOException {

        //코어 로직
        //단어에서 각 문자가 위치하는 자릿수 값을 누적하여
        //누적값이 가장 큰 문자순으로 9~0까지의 정수를 곱하여 준다.

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        //누적값을 저장하기 위한 알파벳 수만큼 배열을 미리 만들어둠
        int[] alphabet = new int[26];

        for (int i = 0; i < t; i++) {

            //단어를 입력받음
            String str = bf.readLine();

            //제곱은 실제 길이 -1부터 시작
            //십진수의 자릿수 값은 398 일 경우(길이가 3)
            //3 : 10의 2승,
            //9 : 10의 1승,
            //8 : 10의 0승 이기 때문에
            int pow = str.length()-1;

            for (int j = 0; j < str.length(); j++) {

                char ch = str.charAt(j);

                //만약 ch가 A일 경우
                //A의 정수값은 65 이므로
                //alphabet[0] += 자릿수값이 됨
                //즉 각 문자의 순번에 해당하는 배열에 자릿수값을 누적함
                alphabet[ch - 'A'] += (int)Math.pow(10, pow--);
            }
        }

        Arrays.sort(alphabet);

        int value = 9;
        int sum = 0;
        for (int i = alphabet.length-1; i >= 0; i--) { //자릿수 누적값이 가장 높은 값에서부터 가장 낮은 값까지 9부터 순차적으로 곱해줌
            if(alphabet[i] == 0)
                break;

            sum += alphabet[i] * value--;
        }

        System.out.println(sum);

    }
}