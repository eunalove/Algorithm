import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] tri) {
        int ans= 0;
        int n= tri.length;
        
        //1. dp배열 생성
        int[][] dp= new int[n][n];
        
        
        //2. 초기값 세팅
        dp[0][0]= tri[0][0];
        
        //3. 왼쪽을 일단 세팅하기
        for(int i=1; i<n; i++)
            dp[i][0]= dp[i-1][0]+ tri[i][0];
        
        
        //3. 왼쪽 위나 오른쪽 위 중에서 더 값이 큰것을 저장함
        for(int i=1; i<n; i++){
            for(int j=1; j<=i; j++){
                dp[i][j]= Math.max(dp[i-1][j],dp[i-1][j-1])+ tri[i][j];
            }
        }
        
        
        //4. 마지막 줄을 돌면서 가장 큰 값을 찾음
        for(int x: dp[n-1])
            ans = Math.max(ans,x);
        
        
        
        return ans;
    }
}
