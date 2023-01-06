package baekjoon.tree_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** 성공 **/
public class B1991_트리순회 {

    static List<Node> nodeList;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        init(n);

        StringTokenizer st;
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(bf.readLine(), " ");

            Node main = nodeList.get(st.nextToken().charAt(0) - 'A');

            String nextToken = st.nextToken();
            if(nextToken.charAt(0) != '.')
                main.left = nodeList.get(nextToken.charAt(0) - 'A');

            nextToken = st.nextToken();
            if(nextToken.charAt(0) != '.')
                main.right = nodeList.get(nextToken.charAt(0) - 'A');

        }

        preOrder(nodeList.get(0));
        System.out.println();
        inOrder(nodeList.get(0));
        System.out.println();
        postOrder(nodeList.get(0));

        System.out.println();

    }

    private static void init(int n) {

        nodeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nodeList.add(new Node((char)('A'+i)));
        }
    }

    static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;

        }
    }


    private static void preOrder(Node node) {

        System.out.print(node.value);

        if(node.left != null)
            preOrder(node.left);

        if(node.right != null)
            preOrder(node.right);
    }

    private static void inOrder(Node node) {

        if(node.left != null)
            inOrder(node.left);

        System.out.print(node.value);

        if(node.right != null)
            inOrder(node.right);
    }

    private static void postOrder(Node node) {

        if(node.left != null)
            postOrder(node.left);

        if(node.right != null)
            postOrder(node.right);

        System.out.print(node.value);
    }

}
