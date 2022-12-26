import java.io.*;

public class 대표값2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 카운팅 정렬 활용하기위해 입력값 담을 배열 선언
        // 100이하 10의 배수이므로 인덱스 값을 줄이기위해 1/10을 적용
        int[] array = new int[11];

        int sum = 0;    // 평균 구하기 위한 합계
        int mid = 0;    // 중간값
        int index = 0;  // 중간값 구하기 위한 index

        for(int i = 0; i < 5; i++) {
            int input = Integer.parseInt(br.readLine());    // 입력값
            if(input != 0) array[input/10] += 1;   // 해당하는 인덱스 배열 값 증가
            else array[0] += 1;
            sum += input;   // 합계
        }

        for(int j = 0; j < 11; j++) {
            if(array[j] != 0) {
                index += array[j]; // 최소값부터 인덱스 배열값 누적
                if(index >= 3) {    // 누적값이 3 이상, 중간값 인덱스 값 저장(10배)
                    mid = j * 10;
                    break;
                }
            }
        }

        sb.append(sum/5).append("\n");
        sb.append(mid);

        System.out.println(sb);
    }
}