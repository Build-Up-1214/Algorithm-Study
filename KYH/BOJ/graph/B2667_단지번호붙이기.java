package baekjoon.graph_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 성공 **/
public class B2667_단지번호붙이기 {

    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(bf.readLine());


        int[][] map = new int[size][size];
        Queue<Integer[]> housePst = new LinkedList<>();

        for(int i = 0; i < size; i++)
        {
            String[] splStr = bf.readLine().split("");
            for(int j = 0; j < splStr.length; j++) {
                map[i][j] = Integer.parseInt(splStr[j]);
                if(map[i][j] == 1)
                    housePst.offer(new Integer[]{i,j});

            }
        }
        solution(housePst, map);
    }

    private static void solution(Queue<Integer[]> housePst, int[][] map) {

        int blockCtn = 0;

        List<Integer> aptCtnList = new ArrayList<>();
        boolean[][] checked = new boolean[map.length][map.length];

        Queue<Integer[]> aptQueueInBlock = new LinkedList<>();

        while (!housePst.isEmpty()) {

            int aptCtnInBlock = 0;
            Integer[] housePosition = housePst.poll();
            if(checked[housePosition[0]][housePosition[1]]) //이미 큐에 담겼었거나, 담겨져 있는 포지션의 집이라면
                continue;

            blockCtn++;
            aptQueueInBlock.offer(housePosition);
            checked[housePosition[0]][housePosition[1]] = true;
            aptCtnInBlock++;

            aptCtnInBlock = search(map, checked, aptQueueInBlock, aptCtnInBlock);
            aptCtnList.add(aptCtnInBlock);
        }

        System.out.println(blockCtn);
        aptCtnList.stream().sorted().forEach(i-> System.out.println(i));
    }

    private static int search(int[][] map, boolean[][] checked, Queue<Integer[]> aptQueueInBlock, int aptCtnInComplex) {

        int[] dx = {0,0,-1,1}; //상하좌우의 x축의 변화량
        int[] dy = {-1,1,0,0}; //상하좌우의 y축의 변화량

        while (!aptQueueInBlock.isEmpty()) {

            Integer[] aptPst = aptQueueInBlock.poll();

            int row = aptPst[0];
            int col = aptPst[1];

            for (int i = 0; i < 4; i++) { //상하좌우 4방의 조건 검사

                int mx = col + dx[i];
                int my = row + dy[i];
                if (mx >= 0 && mx <= size - 1 && my >= 0 && my <= size - 1) { //상하좌우 범위내에 있는지
                    if (!checked[my][mx] && map[my][mx] == 1) { //큐에 담겨져 있거나 큐에 담겨져 처리가 된적이 있는지, 아파트가 존재하는지 체크
                        aptQueueInBlock.offer(new Integer[]{my, mx});
                        checked[my][mx] = true;
                        aptCtnInComplex++;
                    }
                }
            }
        }
        return  aptCtnInComplex;
    }
}

//단지 수 카운팅 정수 변수, blockCtn = 0;
//단지내 아파트수 카운팅 정수 변수, aptCtnInComplex = 0;
//List<Integer> aptCtnInComplexList = new ArrayList<>();
//이미 방문되었거나, 큐에 담겨 있는 집인지 체크하는 map과 동일한 크기의 boolean 배열 변수 선언, checked
//집 큐에 요소가 없을 동안 반복
//  집 큐에서 요소를 꺼냄 (house)
//  이미 checked 배열에서 true라면
//      컨티뉴
//  단지 수 카운팅 변수 + 1
//  단지내 집 큐에 house 를 넣음 (x,y 좌표)
//  checked에 house 좌표 true 체크
//  aptCtnInComplex + 1
//  aptCtnInComplex = bfs(map, checked, aptComplex, aptCtnInComplex)
//  aptCtnInComplexList.add(aptCtnInComplex);
//~반복 종료

//search(map, checked, aptComplex)
//aptComplex에 요소가 없을 동안 반복
//  요소 꺼냄
//  상,하,좌,우 인접 아파트들 aptComplex에 담음 (map에서 1인 좌표), 만약 map의 범위를 넘은 인덱스이거나, 이미 checked가 true인 것은 제외
//  aptComplex에 담길때 해당 좌표 checked에서 true로 체크
//  aptCtnInComplex + 1
//~반복 종료
//리턴 aptCtnInComplex