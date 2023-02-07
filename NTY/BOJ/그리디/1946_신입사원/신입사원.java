import java.util.*;
import java.io.*;

public class 신입사원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] applicant = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicant[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }
            Arrays.sort(applicant, Comparator.comparingInt(a -> a[0]));
            int min = applicant[0][1];
            int fail = 0;
            for (int i = 1; i < N; i++) {
                if(applicant[i][1] < min) min = applicant[i][1];
                else fail++;
            }
            sb.append(N - fail).append('\n');
        }
        System.out.print(sb);
    }
}