import java.io.*;

public class 통계학 {
    private static int[] array;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 입력 개수

        array = new int[8001];    // 입력값: -4000 ~ 4000

        // 카운팅 정렬 위해 입력수를 인덱스로 하는 배열에 카운팅
        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(br.readLine());
            array[index+4000]++;
        }

        mean();;    // 산술평균
        median();   // 중앙값
        mode();     // 최빈값
        range();    // 범위
    }

    private static void mean() {
        int sum = 0;

        for (int i = 0; i < 4000; i++) {
            if(array[i] > 0) {
                sum += (i-4000) * array[i];
            }
        }

        for (int i = 4000; i < 8001; i++) {
            if(array[i] > 0) {
                sum += (i-4000) * array[i];
            }
        }

        System.out.println((int)Math.round(sum/(double)N)); // 소수점 첫째자리 반올림 고려
    }

    private static void median() {
        int count = 0;
        int median = 4001;
        for (int i = 0; i < 8001; i++) {
            if(array[i] > 0) {
                count += array[i];  // 카운팅
                if(count >= N/2 + 1) {  // N은 홀수
                    median = i-4000;
                    break;
                }
            }
        }
        System.out.println(median);
    }

    private static void mode() {
        int mode = 0;
        int max = 0;
        boolean first = false;
        for (int i = 0; i < 8001; i++) {
            if(array[i] > max) {    // 최빈값(첫 등장)
                max = array[i];
                mode = i-4000;
                first = true;
            }
            else if(array[i] == max && first){ // 만약 기존 최빈값 이랑 같으면서 두번째 등장이면
                mode = i-4000;  // 두번째 크기인 값으로 최빈값 저장
                first = false;  // 첫번째인지 유무 리셋 -> 세번째 같은 최빈값부터 if문 생략
            }
        }
        System.out.println(mode);
    }

    private static void range() {
        // 입력 정수 절대값 4000 이내
        int max = -4001;    // 최대값의 최소
        int min = 4001;    // 최소값의 최대

        for (int i = 0; i < 8001; i++) {
            if(array[i] > 0){
                if(i-4000 < min) {
                    min = i-4000;
                }
                if(i-4000 > max) {
                    max = i-4000;
                }
            }
        }
        System.out.println(max-min);
    }
}
