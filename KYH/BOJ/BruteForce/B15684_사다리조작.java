package baekjoon.brute_force_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 성공 **/
public class B15684_사다리조작 {
    static int[][] line;
    static int n;
    static int m;
    static int h;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); //세로선
        m = Integer.parseInt(st.nextToken()); //존재하는 가로 선 갯수
        h = Integer.parseInt(st.nextToken()); //세로 선마다 가로선을 놓을 수 있는 갯수

        line = new int[h+1][n+1]; //편의를 위해 +1씩

        //가로선 1,2,3개를 추가적으로 더 그릴 때의 그리는 상황을 모두 만들어 봄
        //가로선을 각 갯수만큼 다 그렸을때
        //실제로 사다리를 타봄
        //각 세로선에서 출발해봐서 모두 자기 자신에게서 끝나면
        //해당 가로선 갯수가 곧 답
        //근데 결과로 나온 가로선 갯수가 3 초과일때는 -1로 결과 출력

        //필요 로직
        //- 사다리 상태 배열로 담기
        //- 가로선을 긋는 상황에 대한 dfs
        //- 실제 사다리를 타봐서 자기 자신의 세로선에서 끝나는지 확인 로직

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[a][b] = 1;
            line[a][b+1] = -1;
        }

        if (m == 0) {
            System.out.println(0);
            return;
        }

        //0부터 시작해야함.
        //즉, 가로선은 있지만(m이 0이 아님), 가로선을 더 긋지 않아도 이미 각 세로선들이 본인의 위치로 끝나는 경우도 있기 때문에
        //가로선을 추가로 긋지 않았을때도 check()메소드를 돌려봐야함.
        for (int i = 0; i <= 3; i++) {
            if (dfs(0, i)) {
                System.out.println(result);
                return;
            }
        }
        System.out.println(result);
    }

    static boolean dfs(int depth, int maxLine) {

        if (depth == maxLine) {
            if (check()) {
                result = depth;
                return true;
            }
            return false;
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {

                if(line[i][j-1] == 1 ||line[i][j] != 0 || line[i][j+1] != 0)
                    continue;

                line[i][j] = 1;
                line[i][j+1] = -1;

                if (dfs(depth + 1, maxLine)) {
                    return true;
                }
                line[i][j] = 0;
                line[i][j+1] = 0;
            }
        }

        return false;
    }

    static boolean check() {

        for (int i = 1; i <= n; i++) {
            int index = i;
            int level = 1;
            while (level <= h) {

                if (line[level][index] == 1) {
                    index++;
                } else if (line[level][index] == -1) {
                    index--;
                }

                level++;
            }

            if (index != i) {
                return false;
            }
        }
        return true;
    }


}
