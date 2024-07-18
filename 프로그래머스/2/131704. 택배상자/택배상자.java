import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        int container= 1;
        int n= order.length;
        
        Stack<Integer> stack= new Stack<>();
        
        int ans= 0;
        boolean flag= false;
        
        for(int i=0; i<n; i++){
            flag= false;
            if(order[i] >= container){
                
                for(int j=container; j<order[i]+1; j++)
                    stack.add(j);
                
                ans++;
                stack.pop();
                container= order[i]+1;
                flag= true;
            }else{
                
            if(!stack.isEmpty() && order[i] == stack.peek()){
                stack.pop();
                ans++;
                flag= true;
            }
            
            if(!flag) return ans;
        
            }
        }
        return ans;
        
    }
}