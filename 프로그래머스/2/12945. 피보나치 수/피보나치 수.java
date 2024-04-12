import java.io.*;
import java.util.*;

class Solution {
    
    static int sum;
    static int[] dp;
    
    public int solution(int n) {
        
        dp= new int[n+1];
        
        for(int i=0; i<=n; i++)
            dp[i]= -1;
        
        fibo(n);
        
        return dp[n]%1234567;
    }
    
    int fibo(int n){ //n의 피보나치 수를 반환하는 함수
        
        if(n==0) return 0;
        if(n==1) return 1;
        
        if(dp[n] != -1) return dp[n];
        
        dp[n]= fibo(n-2)%1234567 + fibo(n-1)%1234567;
        return dp[n];
        
    }
}