import java.io.*;

public class 쿼드트리 {
    private static int N;
    private static int arr[][];
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) arr[i][j] = s.charAt(j) - '0';
        }

        divide(0, 0, N);
        System.out.println(sb);
        br.close();
    }

    private static void divide(int x, int y, int n) {
        if (!check(x, y, n)) {
            sb.append("(");
            divide(x, y, n / 2);    // 왼쪽 위
            divide(x, y + n / 2, n / 2);    // 오른쪽 위
            divide(x + n / 2, y, n / 2);    // 왼쪽 아래
            divide(x + n / 2, y + n / 2, n / 2);    // 오른쪽 아래
            sb.append(")");
        }
    }

    private static boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[i][j] != arr[x][y]) return false;
            }
        }
        sb.append(arr[x][y]);
        return true;
    }
}
