import java.io.*;
import java.util.*;

public class 회의실배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Meeting> timeLine = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            timeLine.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(timeLine, (t1, t2) -> {
            if(t1.getEnd() != t2.getEnd()) return t1.getEnd() - t2.getEnd();
            else return t1.getStart() - t2.getStart();
        });

        int start = 0;
        int count = 0;
        for (Meeting m : timeLine) {
            if (m.getStart() >= start) {
                count++;
                start = m.getEnd();
            }
        }

        System.out.println(count);
    }

    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return this.start;
        }

        int getEnd() {
            return this.end;
        }
    }
}