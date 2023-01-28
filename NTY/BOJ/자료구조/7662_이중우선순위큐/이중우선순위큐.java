import java.io.*;
import java.util.*;

public class 이중우선순위큐 {
    /*
    우선순위큐 2개 선언해서도 가능(두 큐 동기화 위해 체크 필요)
    TreeMap -> firstkey는 최소 lastkey는 최대값을 갖는 key
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            TreeMap<Integer, Integer> duePQ = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int i = Integer.parseInt(st.nextToken());
                if(s.equals("I")) duePQ.put(i, duePQ.getOrDefault(i, 0) + 1);
                else {  // D 일때
                    if(duePQ.isEmpty()) continue;   // 큐 비어있으면 생략
                    int key = i == 1 ? duePQ.lastKey() : duePQ.firstKey();
                    if(duePQ.get(key) == 1) duePQ.remove(key);  // 초기값이 1이므로 값이 1이면 삭제
                    else duePQ.put(key, duePQ.get(key) - 1);
                }
            }
            if (duePQ.isEmpty()) sb.append("EMPTY").append('\n');
            else sb.append(duePQ.lastKey()).append(' ').append(duePQ.firstKey()).append('\n');
        }

        System.out.println(sb);
    }
}