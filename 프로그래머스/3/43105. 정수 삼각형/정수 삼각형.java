import java.util.*;

class Solution {
    
    public int solution(int[][] tri) {
        int n= tri.length;
        int[][] dp= new int[n][n];
        dp[0][0]= tri[0][0];
        
        for(int i=1; i<n; i++){
            dp[i][0]= dp[i-1][0]+ tri[i][0];
            dp[i][i]= dp[i-1][i-1]+ tri[i][i];
        }
            
            
        for(int i=2; i<n; i++){
            for(int j=1; j<i; j++)
                dp[i][j]= Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
            }
        
        int ans= -1;
    
        for(int i=0; i<n; i++)
            ans= Math.max(ans, dp[n-1][i]);
    
        return ans;
        
    }
}
