import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq= new PriorityQueue<>((pq1, pq2)-> pq2- pq1);
        
        for(int work: works)
            pq.add(work);
        
        while(!pq.isEmpty() && n>0){
            if(pq.peek() >= 1)
            pq.add(pq.poll() -1);
            
            n--;
        }
        long ans= 0;
        
        for(int tmp: pq)
            ans+=  tmp*tmp;
        
        if(!pq.isEmpty()) return ans;
        else return 0;
    }
}