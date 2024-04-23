import java.util.*;

class Solution {
    static int n, ans;
    static boolean[] visited;
    static int[] permul;
    
    public int solution(int k, int[][] dungeons) {
        n= dungeons.length;
        visited= new boolean[n];
        permul= new int[n];
        //순열을 이용해서 dungeons에서 갈 수 있는 모든 수를 구해보자
        dfs(0, dungeons, k);
        
        return ans;
        
    }
    
    static void dfs(int L, int[][] dungeons, int k){
        
        if(L == n){
            
            int max= 0;
            int tmp= k;
            
            for(int i: permul){//1 3 2
                
                if(tmp>= dungeons[i][0]){
                    tmp-= dungeons[i][1];
                    max++;
                }else break;
                
            }
            
            ans= Math.max(ans, max);
            return;
        }
        
        for(int i=0; i<n; i++){
            
            if(!visited[i]){
                permul[L]= i;
                visited[i]= true;
                dfs(L+1, dungeons, k);
                visited[i]= false;
                
            }
        }
    }
}