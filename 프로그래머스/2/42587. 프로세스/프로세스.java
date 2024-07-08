import java.util.*;

class Solution {
    public int solution(int[] prior, int loca) {
        
        PriorityQueue<Integer> pq= new PriorityQueue<>((pq1, pq2) -> pq2- pq1);
        Queue<int[]> q= new ArrayDeque<>();
        
        int i=0;
        for(int pri: prior){
            pq.add(pri);
            q.add(new int[]{pri, i++});
        }
            
        int seq= 1;
        
        while(!q.isEmpty()){
            
            int[] cur= q.poll();
            
            while(!pq.isEmpty() && cur[0] != pq.peek()){
                q.add(cur);
                cur= q.poll();
            }
            
            if(loca == cur[1]) return seq;
            seq++;
            pq.poll();
            
        }
        
        return -1;
    }
}