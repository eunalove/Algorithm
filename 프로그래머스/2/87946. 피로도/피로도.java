import java.util.*;

class Solution {  
    static int ans= 0;
    
    public int solution(int k, int[][] dungeons) { 
        
        boolean[] vis= new boolean[dungeons.length];
        dfs(0, k, vis, dungeons);
        
        return ans;  
    }  
    
    static void dfs(int cnt, int k, boolean[] vis, int[][] dungeons){
            
        ans= Math.max(ans, cnt);
        
        for(int i=0; i<dungeons.length; i++){
            if(vis[i]) continue;
            
            if(dungeons[i][0] <= k) {
            vis[i]= true;
            dfs(cnt+1, k-dungeons[i][1], vis, dungeons);
            vis[i]= false;
            }
            
        }
    
    }
}