import java.util.*;

class Solution {
    public int solution(int storey) {  
    PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2)-> pq1[1]- pq2[1]);
    
    pq.add(new int[]{storey, 0});
    
    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        
        if (cur[0] == 0) return cur[1];
        
        int quo= cur[0] / 10; //1
        int rem= cur[0] % 10; //6
        
        pq.add(new int[]{quo+1, 10 -rem+ cur[1]}); //더했을 때
        pq.add(new int[]{quo, rem+ cur[1]}); //뺐을 때
        
    }
    
    return -1;
}
}