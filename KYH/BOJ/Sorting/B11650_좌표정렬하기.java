package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 성공 **/
public class B11650_좌표정렬하기 {

    static class Point implements Comparable<Point>{
        int x;
        int y;

        @Override
        public int compareTo(Point p) {

            if (this.x == p.x) {
                return this.y - p.y;
            } else {

                return this.x - p.x;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {

            String line = bf.readLine();
            String[] s = line.split(" ");

            Point point = new Point();
            point.x = Integer.parseInt(s[0]);
            point.y = Integer.parseInt(s[1]);
            points[i] = point;
        }

        Arrays.sort(points);
        Arrays.stream(points).forEach(p-> System.out.println(p.x + " " + p.y));
    }
}
