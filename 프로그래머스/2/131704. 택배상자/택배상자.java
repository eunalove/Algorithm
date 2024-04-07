import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] order) {
        int ans = 0;
        
        Queue<Integer> q= new ArrayDeque<Integer>();
        Stack<Integer> stack= new Stack<Integer>();
        
        int n= order.length;
        
        //q1에 1,2,3,4,5 식으로 값 넣어주기
        for(int i=1; i<=n; i++)
            q.add(i);
        
        //order를 돌면서
        for(int o: order){
            
        //스택 제일 앞에 있는지 확인
            if(!stack.isEmpty() && o == stack.peek()){
                ans++;
                stack.pop();
                continue;
            }
            
            
        //큐에서 존재하는지 확인
                boolean flag= false;
                int s= q.size();
                for(int i=0; i<s; i++){//5
                    int top = q.poll();//1 2 3 4
                    if(o==top){
                        flag= true;
                        ans++;
                        break;
                    }
                    stack.add(top);
                    }
                
                
                if(!flag) return ans;
                
            }
        
        return ans;
    }
}