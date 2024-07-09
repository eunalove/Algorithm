class Solution {
    static int ans, n;
    
    public int solution(int[] numbers, int target) {
        n= numbers.length;
        dfs(0, 0, numbers, target);
        
        return ans;
    }
    
    static void dfs(int cnt, int sum, int[] numbers, int target){
        
        if(cnt == n){
            if(sum == target) ans++;
            return;
        }
        
        dfs(cnt+1, sum+ numbers[cnt], numbers, target);
        
        dfs(cnt+1, sum- numbers[cnt], numbers, target);
        
    }
    
    
}