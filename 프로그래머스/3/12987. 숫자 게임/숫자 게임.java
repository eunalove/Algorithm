import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int ans= 0;
        int j=0; 
        
        for(int i=0; i<A.length; i++){
            
            while(j < B.length){
                if(A[i] < B[j]){
                    ans++;
                    j++;
                    break;
                }else j++;
            }
            
            if(j >= B.length) return ans;
        }
        
        return ans;
    }
}