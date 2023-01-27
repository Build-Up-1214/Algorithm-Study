import java.io.*;
import java.util.*;

public class 집합 {
    /*
    HashSet 이용해도 풀이 가능
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int bitMask = 0;
        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add":
                    bitMask |= 1 << Integer.parseInt(st.nextToken());
                    break;
                case "remove":
                    bitMask &= ~(1 << Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    sb.append((bitMask & (1 << Integer.parseInt(st.nextToken()))) > 0 ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    bitMask ^= 1 << Integer.parseInt(st.nextToken());
                    break;
                case  "all" :
                    bitMask = (1 << 21) - 1;
                    break;
                case  "empty" :
                    bitMask = 0;
                    break;
            }
        }

        System.out.println(sb);
    }
}