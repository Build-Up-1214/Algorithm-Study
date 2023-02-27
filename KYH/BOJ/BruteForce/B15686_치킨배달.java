package baekjoon.brute_force_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** 성공 **/
public class B15686_치킨배달 {

    static int n;
    static int m;
    static int[][] map;
    static List<Integer[]> chickenStorePst = new ArrayList<>();
    static List<Integer[]> housePst = new ArrayList<>();
    static int cityChickenDis = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        //전체적인 흐름 수도코드
        //전체 치킨집 갯수를 가지고 m개의 모든 조합을 만들어 낸다.
        //조합이 만들어 질때마다, 해당 조합의 m개의 치킨집이 있는 상황 가정하에
        //각 집들마다 가장 가까운 치킨거리를 구한다
        //각 집들마다 구해진 치킨거리를 합한다.
        //구해진 치킨 거리 중 최소값을 기억한다
        //최종 기억 된 최소값이 곧 도시의 치킨값 이므로 출력한다

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if(input == 1)
                    housePst.add(new Integer[]{i,j});
                else if(input == 2)
                    chickenStorePst.add(new Integer[]{i,j});
            }
        }
        getCombi(0, 0, new ArrayList<>());
        System.out.println(cityChickenDis);
    }

    static void getCombi(int depth, int index, List<Integer[]> combination) {

        if (depth == m) {

            int sum = 0;
            for (int i = 0; i < housePst.size(); i++) {
                int min =Integer.MAX_VALUE;
                for (int j = 0; j < combination.size(); j++) {
                    Integer[] house = housePst.get(i);
                    int dis = Math.abs(house[0] - combination.get(j)[0]) + Math.abs(house[1] - combination.get(j)[1]);
                    if(min > dis)
                        min = dis;

                }
                sum += min;
            }
            if(sum < cityChickenDis)
                cityChickenDis = sum;
            //해당 조건문 수도코드
            //반복문 시작. 집들의 좌표를 순차적으로 접근
            //  int min; 해당 집의 최소 치킨거리 변수;
            //  반복문 시작. m조합의 모든 치킨집 순차적으로 접근
            //      int distance = |집R - 치킨집R| + |집C - 치킨집C|
            //      만약 distance가 min 보다 작다면
            //          min = distance;
            //  반복문 종료
            //반복문 종료
        }

        for (int i = index; i < chickenStorePst.size(); i++) {
            combination.add(chickenStorePst.get(i));
            getCombi(depth+1,i+1,combination);
            combination.remove(combination.size()-1);
        }
    }
}
