import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long ans = 0;
        
        //최대값을 계속 유지하기 위해 pq생성
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());
        int len= works.length;
        
        for(int i=0; i<len; i++)
            pq.add(works[i]);
        
        //n만큼 돌면서 works에서 가장 큰 값에서 1씩 뺀다
        for(int i=0; i<n; i++){
            int tmp= pq.poll();
            if(tmp > 0) //만약 마이너스라면 마이너스*마이너스로 예상치 못한 값이 나올 수 있음
            pq.offer(tmp-1);
            else pq.offer(0);
        }
        
        while(!pq.isEmpty()){//남은 일의 작업량으로 야근지수를 구한다
            int tmp= pq.poll();
            ans+= tmp*tmp;
        }
        
        return ans;
    }
}