import java.util.*;

class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long ans = -1;
        long sum1=0L;
        long sum2=0L;
        
        Queue<Integer> q1= new ArrayDeque();
        Queue<Integer> q2= new ArrayDeque();
        
        //0. 두 큐의 합을 구한다.
        for(int i=0; i<queue1.length; i++){
            sum1+= queue1[i];
            q1.add(queue1[i]);
        }
        
        for(int i=0; i<queue2.length; i++){
            sum2+= queue2[i];
            q2.add(queue2[i]);
        }
        
        if(sum1==sum2) return 0;
        
        int len= queue1.length*2*2;
        
        while(!q1.isEmpty() && !q2.isEmpty()&&ans<=len){
        //1. (n+m)*(n+m)번을 돌면서 두 큐의 앞부분만 비교한다
        if(sum1<sum2){
            sum2-=q2.peek();
            sum1+=q2.peek();
            q1.add(q2.poll());
            ans++;
        }else if(sum1>sum2){
            sum1-=q1.peek();
            sum2+=q1.peek();
            q2.add(q1.poll());
            ans++;
        }else{
        return ans+1;
        }
        }
        
        return -1;
    }
}