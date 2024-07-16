import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if(n> s) return new int[]{-1};
        
        int div= s/n; //4
        int rem= s%n; //1
        
        int[] ans= new int[n];
        if(n%s == 0){
            Arrays.fill(ans, div);
        }else{
        
        for(int i=0; i<n- rem; i++)
            ans[i]= div;
            
        for(int i=n-rem; i<n; i++)
            ans[i]= div+1;
            
        }
        return ans;
        
    }
}