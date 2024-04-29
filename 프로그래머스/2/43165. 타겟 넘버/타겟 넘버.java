class Solution {
    static int n, ans;
    
    public int solution(int[] numbers, int target) {
        n= numbers.length;
        
        dfs(numbers, target, 0, 0);
        
        return ans;
    }
    
    static void dfs(int[] numbers, int target, int L, int sum){
        
        if(L == n){
            if(sum == target) ans++;
            return;
        }
        
        dfs(numbers, target, L+1, sum+ numbers[L]);
        dfs(numbers, target, L+1, sum- numbers[L]);
        
    }
}