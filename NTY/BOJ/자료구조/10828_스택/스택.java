import java.io.*;
import java.util.StringTokenizer;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력

        int N = Integer.parseInt(br.readLine());    // 명령의 수

        Stack stack = new Stack(N);     // Stack 생성

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());    // 공백단위로 구분
            switch(st.nextToken()) {    // 첫번째 단어 즉, 명령어 기준으로 case 나누어 실행
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(Integer.valueOf(stack.pop()) + "\n");
                    break;
                case "size":
                    bw.write(Integer.valueOf(stack.size()) + "\n");
                    break;
                case "empty":
                    bw.write(Integer.valueOf(stack.empty()) + "\n");
                    break;
                case "top":
                    bw.write(Integer.valueOf(stack.top()) + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Stack {
        private int top;
        private int stackArr[];

        public Stack(int size) {
            this.top = -1;  // -1부터 시작 -> index 0 고려
            this.stackArr = new int[size];  // size 크기의 배열생성(최대 크기 -> 다 push 경우)
        }

        // 명령어 push
        public void push(int x){
            this.stackArr[++top] = x;   // 가리키는 위치(맨 위) 증가 후 삽입
        }

        // 명령어 pop
        public int pop(){
            if(top == -1) return -1;    // 삽입된게 없으면 -1
            return this.stackArr[top--];    // 가리키는 위치(맨 위) 감소
        }

        // 명령어 size
        public int size() {
            return this.top + 1;    // 초기값 -1 이므로
        }

        // 명령어 empty
        public int empty() {
            if(top == -1) return 1; // 초기값이면, push 된게 없으면 1
            return 0;   // 존재하면 0
        }

        // 명령어 top
        public int top() {
            if(top == -1) return -1;   // 삽입된게 없으면 -1
            else return this.stackArr[top]; // 제일 마지막으로 가리키는 것 반환
        }
    }
}

