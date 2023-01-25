import java.io.*;
import java.util.*;

public class 공유기설치 {
    private static int N, C;
    private static int[] line;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        line = new int[N]; // 입력(집 위치) 저장할 배열

        for (int i = 0; i < N; i++) line[i] = Integer.parseInt(br.readLine());

        Arrays.sort(line);

        if(N == C) System.out.println((line[N - 1] - line[0]) / (N - 1)); // 집 개수와 공유기 개수 같을 때
        else{
            int low = 1;
            int high = line[N - 1] - line[0];
            while(low <= high){
                int mid = (low + high) / 2;
                if(check(mid)) low = mid + 1;
                else high = mid - 1;
            }
            System.out.println(high);
        }
    }

    // 거리를 x 만큼 두었을 때 최소 C개 이상 설치 가능한지 체크
    private static boolean check(int x){
        int install = 1;
        int index = line[0];
        for (int i = 1; i < N; i++) {
            if(line[i] - index >= x) {
                install++;
                index = line[i];
            }
        }
        return install >= C;
    }
}