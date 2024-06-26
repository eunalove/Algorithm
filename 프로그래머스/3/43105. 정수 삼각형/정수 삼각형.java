import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[][] tri) {
        int n= tri.length;
        int ans= Integer.MIN_VALUE;
        
        int[][] dp= new int[n][n];
        
        dp[0][0]= tri[0][0];
        
        for(int i=0; i<n-1; i++){
            for(int j=0; j<=i; j++){
                
            dp[i+1][j]= Math.max(dp[i+1][j], tri[i+1][j] + dp[i][j]);
            dp[i+1][j+1]= Math.max(dp[i+1][j+1], tri[i+1][j+1] + dp[i][j]);
            }
        }
        
        for(int val: dp[n-1])
            ans= Math.max(val, ans);
        
        return ans;
    }
    
}
