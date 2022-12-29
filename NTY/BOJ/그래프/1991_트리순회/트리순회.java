import java.io.*;
import java.util.*;

public class 트리순회 {
    private static int N, nodeIndex;
    private static String[][] tree;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new String[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree[i][0] = st.nextToken();
            tree[i][1] = st.nextToken();
            tree[i][2] = st.nextToken();
        }

        pre(0);
        sb.append("\n");
        mid(0);
        sb.append("\n");
        last(0);

        System.out.println(sb);
    }

    private static void pre(int i) {
        sb.append(tree[i][0]);
        if (findNode(tree[i][1])) {
            pre(nodeIndex);
        } else if(!tree[i][1].equals(".")){
            sb.append(tree[i][1]);
        }
        if (findNode(tree[i][2])) {
            pre(nodeIndex);
        } else if(!tree[i][2].equals(".")){
            sb.append(tree[i][2]);
        }
    }

    private static void mid(int i) {
        if (findNode(tree[i][1])) {
            mid(nodeIndex);
        } else if(!tree[i][1].equals(".")){
            sb.append(tree[i][1]);
        }
        sb.append(tree[i][0]);
        if (findNode(tree[i][2])) {
            mid(nodeIndex);
        } else if(!tree[i][2].equals(".")){
            sb.append(tree[i][2]);
        }
    }

    private static void last(int i) {
        if (findNode(tree[i][1])) {
            last(nodeIndex);
        } else if(!tree[i][1].equals(".")){
            sb.append(tree[i][1]);
        }
        if (findNode(tree[i][2])) {
            last(nodeIndex);
        } else if(!tree[i][2].equals(".")){
            sb.append(tree[i][2]);
        }
        sb.append(tree[i][0]);
    }

    private static boolean findNode(String node) {
        for (int i = 0; i < N - 1; i++) {
            if(tree[i][0].equals(node)) {
                nodeIndex = i;
                return true;
            }
        }
        return false;
    }
}