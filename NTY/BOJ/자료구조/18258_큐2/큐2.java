import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐2{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue queue = new Queue();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.empty()).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}

class Queue{
    private final LinkedList<Integer> linkedList;

    public Queue() {
        this.linkedList = new LinkedList<>();
    }

    public void push(int X) {
        this.linkedList.addLast(X);
    }

    public int pop() {
        if(linkedList.isEmpty()) return -1;
        else return this.linkedList.removeFirst();
    }

    public int size() {
        return linkedList.size();
    }

    public int empty() {
        if(linkedList.isEmpty()) return 1;
        else return 0;
    }

    public int front() {
        if(linkedList.isEmpty()) return -1;
        else return this.linkedList.getFirst();
    }

    public int back() {
        if(linkedList.isEmpty()) return -1;
        else return this.linkedList.getLast();
    }
}