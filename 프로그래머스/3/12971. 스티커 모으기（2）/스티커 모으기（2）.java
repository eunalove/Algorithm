class Solution {
    public int solution(int sticker[]) {
        
        int n= sticker.length;
        
        if(n==1) return sticker[0];
        
        int[] dp1= new int[n];
        int[] dp2= new int[n];
        
        dp1[0]= sticker[0];
        dp1[1]= sticker[0];
        
        for(int i=2; i<n-1; i++)
            dp1[i]= Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        
        dp2[0]= 0;
        dp2[1]= sticker[1];
        
        for(int i=2; i<n; i++)
            dp2[i]= Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        
        int ans= 0;
        
        for(int i=0; i<n; i++)
            ans= Math.max(dp1[i], ans);
        
        for(int i=0; i<n; i++)
            ans= Math.max(dp2[i], ans);
        
        return ans;
    }
}