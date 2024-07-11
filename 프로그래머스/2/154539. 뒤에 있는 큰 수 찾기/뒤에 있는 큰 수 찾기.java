import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        int n= numbers.length;
        int[] ans= new int[n];
        
        for(int i=0; i<n; i++)
            ans[i]= -1;
        
        Stack<int[]> stack= new Stack<>();
        
        for(int i=0; i<n; i++){
            
            while(!stack.isEmpty() &&stack.peek()[1] < numbers[i]){
                
                ans[stack.peek()[0]]= numbers[i];
                stack.pop();
            }
            stack.add(new int[]{i, numbers[i]});
            
        }
        
        return ans;
    }
}