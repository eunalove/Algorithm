import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int n= citations.length;
        int max= citations[n -1];
        int idx= 0;
        if(max == 0) return 0;
        for(int i=0; i<=max; i++){
            if(i >= citations[idx]) idx++;
            if(i >= n -idx) return i;
        }
            
        return -1;
        
    }
}