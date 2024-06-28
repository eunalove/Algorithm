class Solution {
    public int solution(int n) {
        int ans = 0;
        int sum= 0;
        
        for(int start=1; start<=n; start++){
            sum =0;
            for(int end=start; end<= n; end++){
                sum+= end;
                if(sum == n){
                    ans++;
                    sum= 0;
                    break;
                }
                if(sum > n) break;
            }
        }
        
        return ans;
    }
}