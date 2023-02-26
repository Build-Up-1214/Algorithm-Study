package baekjoon.implement_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 성공 **/
public class B12904_A와B {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder(bf.readLine());
        StringBuilder t = new StringBuilder(bf.readLine());

        while (s.length() < t.length()) {

            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length()-1);
            }else{
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }

        if (s.toString().equals(t.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
