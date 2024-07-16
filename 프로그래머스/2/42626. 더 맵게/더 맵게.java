import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int ans =0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        
        for(int sc: scoville)
            pq.add(sc);
        
        while(pq.size()>=2 && pq.peek() < K){
            ans++;
            int one= pq.poll();
            int two= pq.poll();
            
            pq.add(one+ two*2);
        }
        
        if(pq.peek() < K) return -1;
        
        return ans;
        
    }
}