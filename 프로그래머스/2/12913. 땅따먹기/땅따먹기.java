class Solution {
    int solution(int[][] land) {
        
        int n= land.length;
        int[][] dp= new int[n][4];
        
        for(int j=0; j<4; j++)
            dp[0][j]= land[0][j];
        int sum= 0;
            
        for(int i=1; i<n; i++){
            for(int j=0; j<4; j++){
                sum =0;
                for(int k=0; k<4; k++){
                    if(j==k) continue;
                    sum= Math.max(sum, dp[i-1][k]);
                }
                    dp[i][j]= sum+ land[i][j];
            }
        }
        
        int ans= 0;
        
        for(int i=0; i<4; i++)
            ans= Math.max(ans, dp[n-1][i]);
        
        return ans;
        
    }
}