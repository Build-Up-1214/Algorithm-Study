import java.io.*;

public class 수정렬하기3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력
        StringBuilder sb = new StringBuilder();     // 출력

        int N = Integer.parseInt(br.readLine());    // 입력 수의 개수

        /*
         * 카운팅 정렬
         * 입력 수는 10,000보다 작거나 같은 자연수
         */
        int[] array = new int[10001];   // 입력 수을 인덱스로 하여 입력 개수 담을 배열,

        for (int i = 0; i < N; i++) {   // 입력수를 인덱스로 입력 수 카운팅
            int index = Integer.parseInt(br.readLine());
            array[index]++;
        }

        for (int j = 1; j < 10001; j++) {
            if(array[j] > 0) {  // while 문 있어서 없어도 되나, if로 먼저 걸러주면 아주 미세하게 빠르다(문제에서 20ms 정도)
                while (array[j] > 0) {
                    sb.append(j).append("\n");
                    array[j]--;
                }
            }
        }

        br.close();
        System.out.println(sb);
    }
}