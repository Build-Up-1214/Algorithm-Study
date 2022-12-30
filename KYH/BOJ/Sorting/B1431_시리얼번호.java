package baekjoon.sort_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 성공 **/
public class B1431_시리얼_번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] strArr = new String[n];

        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }

        for (int i = 0; i < n - 1; i++) {

            int curSerialIdx = i;
            for (int j = i + 1; j < n; j++) {

                if(strArr[curSerialIdx].length() > strArr[j].length())
                {
                        curSerialIdx = j;
                }
                else if(strArr[curSerialIdx].length() == strArr[j].length())
                {
                    int curSerialIdxHap = 0;

                    for(int z = 0; z < strArr[curSerialIdx].length(); z++)
                    {
                        if (strArr[curSerialIdx].charAt(z) >= '0' && strArr[curSerialIdx].charAt(z) <= '9') {
                            curSerialIdxHap += Integer.valueOf(String.valueOf(strArr[curSerialIdx].charAt(z)));
                        }
                    }

                    int jHap = 0;
                    for(int z = 0; z < strArr[j].length(); z++)
                    {
                        if (strArr[j].charAt(z) >= '0' && strArr[j].charAt(z) <= '9') {
                            jHap += Integer.valueOf(String.valueOf(strArr[j].charAt(z)));
                        }
                    }

                    if (curSerialIdxHap > jHap) {
                        curSerialIdx = j;
                    } else if (curSerialIdxHap == jHap) {
                        String[] temp = new String[2];
                        temp[0] = strArr[curSerialIdx];
                        temp[1] = strArr[j];
                        Arrays.sort(temp);

                        if (temp[0] != strArr[curSerialIdx]) {
                            curSerialIdx = j;
                        }
                    }
                }
            }

            if (curSerialIdx != i) {
                String temp = strArr[curSerialIdx];
                strArr[curSerialIdx] = strArr[i];
                strArr[i] = temp;
            }
        }

        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
        }

        //1 ~ n-1 까지 요소 접근 하는 반복문 (i)
        //  curSerialIdx(i번째에 들어갈 요소의 인덱스), i로 초기화
        //  i+1 ~ n 까지 요소 접근 하는 반복문 (j)
        //      만약 i번째 보다 j번째의 길이가 짧다면
        //          curSerialIdx = j
        //      같다면
        //          i번째 문자열의 요소들 중 숫자 합 구함
        //          j번째 문자열의 요소들 중 숫자 합 구함
        //          만약 i번째 문자열의 숫자합 보다 j번째 문자열의 숫자합이 작은 경우
        //              curSerialIdx = j
        //          같다면
        //              i, j 문자열을 사전순으로 정렬하여 먼저인것을 curSerialIdx 에 넣음
        //  반복문 종료
        //~반복문 종료
    }
}
