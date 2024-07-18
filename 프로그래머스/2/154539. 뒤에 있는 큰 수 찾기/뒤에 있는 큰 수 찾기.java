import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
    
    int[] ans= new int[numbers.length];
        Arrays.fill(ans, -1);
        
     Stack<int[]> stack= new Stack<>();
        
    for(int i=0; i<numbers.length; i++){
    
        while(!stack.isEmpty() && stack.peek()[0] < numbers[i])
            ans[stack.pop()[1]]= numbers[i];
        
        
        stack.add(new int[]{numbers[i], i});
    }
        return ans;
    
    }
}