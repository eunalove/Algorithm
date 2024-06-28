class Solution {
    public int solution(int n) {
        int ans = 1;
        int sum= 0;
        
        for(int start=1; start<=n/2; start++){
            sum= 0;
            int end= start;
            while(sum < n){
                
                sum+= end;
                end++;
                
            }
            if(sum == n) ans++;
            }
        
        
        return ans;
    }
}