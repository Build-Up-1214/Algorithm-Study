import java.io.*;
import java.util.*;

public class 단어정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 입력 개수

        String[] strings = new String[N];   // 단어 담을 배열

        for(int i = 0; i < N; i++){
            strings[i] = br.readLine(); // 배열저장
        }

        // 배열 정렬 -> comparator(람다식)
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.length() == s2.length()){ // 단어 길이 같으면
                return s1.compareTo(s2);    // 사전 순으로 정렬(compareTo)
            }
            else return s1.length() - s2.length();  // 단어 길이로 정렬
        });

        bw.write(strings[0] + "\n");
        for(int i = 1; i < N; i++){
            if(!strings[i].equals(strings[i-1])){   // 중복 제거
                bw.write(strings[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}