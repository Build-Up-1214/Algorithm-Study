import java.io.*;
import java.util.*;

public class 나이순정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Member> memberList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            memberList.add(new Member(age, name));
        }

        Collections.sort(memberList, (m1, m2) -> m1.getAge() - m2.getAge());

        for (Member m : memberList) {
            sb.append(m.getAge()).append(" ").append(m.getName()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static class Member{
        private final int age;
        private final String name;
        private Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
        private String getName() {
            return this.name;
        }
        private int getAge(){
            return this.age;
        }
    }
}