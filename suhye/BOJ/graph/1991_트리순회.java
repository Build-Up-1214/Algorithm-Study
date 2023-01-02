import java.util.*;
import java.io.*;

class Node {
    char data;
    Node left;
    Node right;
    Node(char data) {
        this.data = data;
    }
}

class Tree {
    Node root;
    public void createNode(char data, char leftData, char rightData) {
        if(root == null) { // 처음 생성할 경우 루트 노드 A 생성
            root = new Node(data);
            if(leftData != '.') {
                root.left = new Node(leftData);
            }
            if(rightData != '.') {
                root.right = new Node(rightData);
            }
        } else { // 처음이 아닐 경우, 트리 탐색을 진행해서 적절한 위치에 삽입
            searchNode(root, data, leftData, rightData);
        }
    }

    public void searchNode(Node root, char data, char leftData, char rightData) {
        if(root == null) { // 도착한 노드가 null일 경우
            return;
        } else if(root.data == data) { // 삽입위치 발견
            if(leftData != '.') {
                root.left = new Node(leftData);
            }
            if(rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root.left, data, leftData, rightData); // 왼쪽부분 탐색
            searchNode(root.right, data, leftData, rightData); // 오른쪽부분 탐색
        }
    }

    // 전위순회 : 루트 -> 왼 -> 오
    public void preorder(Node root){
        System.out.print(root.data);
        if (root.left != null) preorder(root.left);
        if (root.right != null) preorder(root.right);
    }

    // 중위순회 : 왼 -> 루트 -> 오
    public void inorder(Node root){
        if (root.left != null) inorder(root.left);
        System.out.print(root.data);
        if (root.right != null) inorder(root.right);
    }

    // 후위순회 : 왼 -> 오 -> 루트
    public void postorder(Node root){
        if (root.left != null) postorder(root.left);
        if (root.right != null) postorder(root.right);
        System.out.print(root.data);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for(int i = 0; i < N; i++) {
            char[] data = br.readLine().replaceAll(" ", "").toCharArray();
            tree.createNode(data[0], data[1], data[2]);
        }

        //전위 순회
        tree.preorder(tree.root);
        System.out.println();

        //중위 순회
        tree.inorder(tree.root);
        System.out.println();

        //후위 순회
        tree.postorder(tree.root);

    }

}