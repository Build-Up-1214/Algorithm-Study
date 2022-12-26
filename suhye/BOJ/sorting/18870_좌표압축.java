import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] originArr = arr.clone();
        Arrays.sort(arr);
        int compression = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], compression);
                compression++;
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(map.get(originArr[i])).append(" ");
        }
        System.out.println(sb);
    }
}