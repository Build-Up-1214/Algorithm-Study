import java.util.ArrayList;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(k);
        while(k!=1) {
            if(k%2==0) k /= 2;
            else {
                k *= 3;
                k++;
            }
            list.add(k);
        }

        double[] calc = new double[list.size()-1];

        for(int i=0; i<list.size()-1; i++) calc[i] = (double)(list.get(i)+list.get(i+1))/2;

        for(int i=0; i<ranges.length; i++) {
            double result = 0;
            int s = ranges[i][0];
            int e = list.size()+ranges[i][1]-1;

            if(s>e) answer[i] = -1;
            else {
                for(int j=s; j<e; j++) result += calc[j];
                answer[i] = result;
            }
        }
        return answer;
    }
}