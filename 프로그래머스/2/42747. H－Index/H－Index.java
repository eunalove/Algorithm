import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int ans= 0;
        int n= citations.length;
        
        for(int h=1; h<n+1; h++){
            for(int i=0; i<n; i++)
                if(citations[i] >= h){
                    if(n - i >= h){
                        ans= Math.max(ans, h);
                        break;
                    }
                }
        }
        
        return ans;
    }
}
