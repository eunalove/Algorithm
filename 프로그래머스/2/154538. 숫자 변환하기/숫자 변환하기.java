import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((pq1, pq2) ->{
            if(pq1[1] == pq2[1]) return pq2[0] - pq1[0];
            return pq1[1] - pq2[1];
        });
        
        Set<Integer> vis= new HashSet<>();
        
        pq.add(new int[]{x, 0});
        
        while(!pq.isEmpty()){
            
            int[] cur= pq.poll();
            if(vis.contains(cur[0])) continue;
            vis.add(cur[0]);
            if(cur[0] == y) return cur[1];
            if(cur[0]+n <= y) pq.add(new int[]{cur[0]+n, cur[1]+1}); 
            if(cur[0]*2 <= y) pq.add(new int[]{cur[0]*2, cur[1]+1}); 
            if(cur[0]*3 <= y) pq.add(new int[]{cur[0]*3, cur[1]+1}); 
            
        }
        
        return -1;
    }
}