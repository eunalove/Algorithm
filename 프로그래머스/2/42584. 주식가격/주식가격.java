import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        Stack<int[]> stack= new Stack<>();
        int n= prices.length;
        int[] ans= new int[n];
        
        for(int i=0; i<n; i++){
            
            while(!stack.isEmpty() && stack.peek()[0] > prices[i]){
            
                    int[] top= stack.pop();
                    ans[top[1]]= i - top[1];
                    
            }
            stack.add(new int[]{prices[i], i});
        }
        
        while(!stack.isEmpty()){
            
            int[] top= stack.pop();
             ans[top[1]]= n -1 - top[1];
            
        }
        
        return ans;
    }
}