import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long ans = 0;
        
        //그리디가 과연 맞을까?
        
        //최대값을 계속 유지하기 위해 pq생성
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());
        int len= works.length;
        
        for(int i=0; i<len; i++)
            pq.add(works[i]);
        
        //n만큼 돌면서 works에서 가장 큰 값에서 1씩 뺀다
        for(int i=0; i<n; i++){
            int tmp= pq.poll();
            if(tmp > 0)
            pq.offer(tmp-1);
            else pq.offer(0);
        }
        
        while(!pq.isEmpty()){
            int tmp= pq.poll();
            ans+= tmp*tmp;
        }
        
        return ans;
    }
}