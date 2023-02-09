package baekjoon.brute_force_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B1062_가르침 {

    static int max = 0;
    static String[] words; //존재하는 단어
    static boolean[] alphabet = new boolean[26]; //가르친 문자 체크하는 배열
    static int n,k;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken()); //단어 갯수
        k = Integer.parseInt(st.nextToken()); //가르칠 수 있는 문자 갯수

        //단어에 무조건 들어가는 문자들 true로 체크
        alphabet['a'-'a'] = true;
        alphabet['c'-'a'] = true;
        alphabet['i'-'a'] = true;
        alphabet['n'-'a'] = true;
        alphabet['t'-'a'] = true;

        //단어 입력받음
        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = bf.readLine();
        }

        //가르칠 수 있는 문자가 5개 미만이면 단어에 무조건 들어가는 acint 조차 가르칠 수 없기 때문에 검사 조차 필요 없음
        if (k < 5) {
            System.out.println(0);
            return;
        }
        dfs(5, 0);

        System.out.println(max);
    }

    //가르칠 문자 조합 구함
    static void dfs(int chCtn, int index) {

        if (chCtn == k) {
            int learnCtn = checkWord();
            if(learnCtn > max)
                max = learnCtn;

            return;
        }

        for (int i = index; i < 26; i++) {

            if(alphabet[i])
                continue;

            alphabet[i] = true;
            dfs(chCtn+1, i+1);
            alphabet[i] = false;
        }
    }

    //배울 수 있는 단어 갯수 체크
    static int checkWord() {
        int ctn = 0;
        for (int i = 0; i < words.length; i++) {
            boolean check = true;
            String word = words[i];
            for (int j = 4; j < word.length() - 4; j++) {
                char c = word.charAt(j);
                if (!alphabet[c - 'a']) {
                    check = false;
                    break;
                }
            }

            if(!check)
                continue;
            ctn++;
        }
        return ctn;
    }
}



