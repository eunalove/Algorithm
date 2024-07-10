import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        
        int[] dx= {-1, 1, 0, 0};
        int[] dy= {0, 0, -1, 1};
        
        int n= maps.length;
        int m= maps[0].length;
        
        Queue<int[]> q= new ArrayDeque<>();
        boolean[][] vis= new boolean[n][m];
        q.add(new int[]{0, 0, 1});
        
        while(!q.isEmpty()){
            
            int[] cur= q.poll();
            
            if(cur[0]== n-1 && cur[1]== m-1) return cur[2];
            
            for(int i=0; i<4; i++){
                
                int nx= cur[0] + dx[i];
                int ny= cur[1] + dy[i];
                
                if(nx<0 || ny<0 || nx>=n || ny>=m|| maps[nx][ny] == 0) continue;
                
                if(!vis[nx][ny]){
                    vis[nx][ny]= true;
                    q.add(new int[]{nx, ny, cur[2]+1});
                }
            }
        }
        
        return -1;
    }
}