package baekjoon.DivideAndConquer_분할정복;

import java.io.*;

public class B2447_별찍기10 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());

        arr = new char[n][n];

        makeStar(0,0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == '*')
                    bw.write(arr[i][j]);
                else
                    bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static void makeStar(int row, int col, int size) {

        if(size == 1){
            arr[row][col] = '*';
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                if(!(i==1 && j==1))
                    // x, y 값을 계속 유지하며 재귀 호출
                    makeStar(row + i*size/3, col + j*size/3, size/3);
            }
        }
    }
}