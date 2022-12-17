import java.io.*;
import java.util.*;

public class 나는야포켓몬마스터이다솜{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력

        StringTokenizer st = new StringTokenizer(br.readLine());    // 첫번째 명령어 수 파악

        int N = Integer.parseInt(st.nextToken());   // 포켓몬 수
        int M = Integer.parseInt(st.nextToken());   // 문제 수

        ArrayList<String> al = new ArrayList<>(N); // 포켓몬 저장할 arraylist(인덱스 기준)
        HashMap<String, Integer> hm = new HashMap<>();  // 포켓몬 저장할 arraylist(이름 기준)

        for(int i = 0; i < N; i++) {    // 포켓몬 저장
            String name = br.readLine();
            al.add(i, name);
            hm.put(name, i);
        }

        long startTime1 = System.currentTimeMillis();   // 시간측정

        for(int j = 0; j < M; j++) {
            String findName = br.readLine();    // 명령어 입력
            try {
                bw.write(al.get(Integer.parseInt(findName) - 1) + "\n");    // 문제가 숫자일 경우(인덱스) 포켓몬 이름 반환
            } catch (NumberFormatException n) { // 숫자로 못바꿔서 exception 발생 -> 숫자(인덱스)가 아니고 포켓몬 이름이 문제일 때
                bw.write(hm.get(findName) + 1 + "\n");  // 포켓몬 이름으로 찾아서 숫자(인덱스) 반환
            }
        }

        long finishTime1 = System.currentTimeMillis();  // 시간측정

//        long startTime2 = System.currentTimeMillis();
//
//        for(int j = 0; j < M; j++) {
//            String findName = br.readLine();
//            try {
//                bw.write(al.get(Integer.parseInt(findName) - 1) + "\n");
//            } catch (NumberFormatException n) {
//                bw.write(al.indexOf(findName) + 1 + "\n");
//            }
//        }
//
//        long finishTime2 = System.currentTimeMillis();


        System.out.println("포켓몬 도감 찾는데 걸린시간(hashmap 추가 사용) :" + (finishTime1 - startTime1));    // 이름으로 찾는 경우가 많아질수록 효율이 좋아짐
//        System.out.println("포켓몬 도감 찾는데 걸린시간(arraylist(indexOf()포함)만 사용) :" + (finishTime2 - startTime2)); // 시간 초과 발생

        bw.flush();
        bw.close();
        br.close();
    }
}