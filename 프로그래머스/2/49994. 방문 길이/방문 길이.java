import java.util.*;

class Solution {
    public int solution(String dirs) {
        int n= dirs.length();
        
        int ans = 0;
        boolean[][][] vis= new boolean[11][11][4];
        int nx= 5;
        int ny= 5;
        
        for(int i=0; i<n; i++){
            
            switch(dirs.charAt(i)){
                    
                case 'U': if(nx-1 >= 0) {
                    if(!vis[nx-1][ny][0] && !vis[nx][ny][1]) ans++;
                    vis[nx-1][ny][0]= true;
                    vis[nx][ny][1]= true;
                    nx-=1;
                    
                }
                    break;
                    
                case 'D': if(nx+1 <= 10){
                    if(!vis[nx+1][ny][1] && !vis[nx][ny][0]) ans++;
                    vis[nx+1][ny][1]= true;
                    vis[nx][ny][0]= true;
                    nx+=1;
                    
                } 
                    break;
                    
                case 'R': if(ny+1 <= 10){
                    if(!vis[nx][ny+1][2] && !vis[nx][ny][3]) ans++;
                    vis[nx][ny+1][2]= true;
                    vis[nx][ny][3]= true;
                    ny+=1;
                    
                } 
                    break;
                    
                case 'L': if(ny-1 >= 0){
                    if(!vis[nx][ny-1][3] && !vis[nx][ny][2]) ans++;
                    vis[nx][ny-1][3]= true;
                    vis[nx][ny][2]= true;
                    ny-=1;
                    
                }
                    
            }
        
        
        }
        
        
        return ans;
    }
}