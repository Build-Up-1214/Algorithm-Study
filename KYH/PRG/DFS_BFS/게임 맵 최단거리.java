import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
    
        int[] dx = {0,0,-1,1}; //상하좌우
        int[] dy = {-1,1,0,0}; //상하좌우
        int[][] pathCtn = new int[maps.length][maps[0].length];
        pathCtn[0][0] = 1; //최초 시작 위치만 1로 초기화
        
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        queue.offer(new Integer[]{0,0});
  
        while(!queue.isEmpty())
        {
            Integer[] curPst = queue.poll();    
            
            if(curPst[0] == maps[0].length-1 && curPst[1] == maps.length-1)
            {
                break;
            }
            
            for(int i = 0; i < 4; i++)
            {
                int nx = curPst[0] + dx[i];
                int ny = curPst[1] + dy[i];
                int nPathCtn = pathCtn[curPst[1]][curPst[0]] + 1;
                
                if(nx >= 0 && ny >= 0 && nx <= maps[0].length-1 && ny <= maps.length-1){
                    if(maps[ny][nx] == 1 && (pathCtn[ny][nx] == 0 || nPathCtn < pathCtn[ny][nx]))
                    {
                        pathCtn[ny][nx] = nPathCtn;
                        queue.offer(new Integer[]{nx,ny});
                    }
                }
            }
        }
        
        if(pathCtn[maps.length-1][maps[0].length-1] != 0)
            return pathCtn[maps.length-1][maps[0].length-1];
        else
            return -1;
        
    }

}