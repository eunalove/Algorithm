import java.util.*;

class Solution {
    public int solution(String s) {
        int ans = 0;
        int n= s.length();
        
        Stack<Character> stack;
        
        for(int i=0; i<n; i++){
            stack= new Stack<>();
            for(int j=0; j<n; j++){
                if(!stack.isEmpty() && stack.peek() == '[' && s.charAt((i+j)%n) == ']') stack.pop(); 
                else if(!stack.isEmpty() && stack.peek() == '(' && s.charAt((i+j)%n) == ')') stack.pop(); 
                else if(!stack.isEmpty() && stack.peek() == '{' && s.charAt((i+j)%n) == '}') stack.pop(); 
                else stack.add(s.charAt((i+j)%n));
            }
            if(stack.isEmpty()) ans++;
        }
        
        return ans;
    }
}