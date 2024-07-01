import java.util.Stack;

class Solution {
    public int solution(String s) {
        
        Stack<Character> stack= new Stack<>();
        
        char[] array= s.toCharArray();
        
        for(char c: array){
            
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
            
            
        }
        
        if(stack.isEmpty()) return 1;
        else return 0;
        
    }
}
