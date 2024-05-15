import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int ans = 0;
        
        //알고리즘: DFS/BFS/DP/냅색/브루트포스/MST/다이나믹/그래프/유니온파인드/정렬/이분탐색
        
        //정렬-> 브루트포스로 하나하나 돌리기
        
        Arrays.sort(citations); //10, 11
        int n= citations.length;
        
        for(int h=1; h<=n; h++){ //2
            
        int citation= citations[h-1]; //11
        int h2= 0;
            
            for(int j=0; j<n; j++){ //0
                
                if(citations[j] >= h) h2++;
            }
            
            
            //h2번 이상 인용된 논문이 h편 이상일 때
            if(h2 >= h)
            ans= h;
            
        }
        
        return ans;
    }
}