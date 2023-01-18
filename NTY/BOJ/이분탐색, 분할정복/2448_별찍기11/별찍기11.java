import java.io.*;

public class 별찍기11 {
    private static boolean arr[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        arr = new boolean[N][N * 2 - 1];

        f(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++){
                if(arr[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void f(int x, int y, int n) {
        if(n == 3){ // 최소 별
            arr[x][y] = true;
            arr[x + 1][y - 1] = arr[x + 1][y + 1] = true;
            arr[x + 2][y - 2] = arr[x + 2][y - 1] = arr[x + 2][y] = arr[x + 2][y + 1] = arr[x + 2][y + 2] = true;
        } else {
            f(x, y, n / 2); // 중앙
            f(x + n / 2, y - n / 2, n / 2); // 왼쪽
            f(x + n / 2, y + n / 2, n / 2); // 오른쪽
        }
    }
}