import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        HashSet<Integer> set= new HashSet<>();
        int e= 0;
        int sum= 0;
        int n= elements.length;
        for(int s= 0; s<n; s++){
            e= s+1;
            set.add(elements[s]);
            sum+= elements[s];
            while(e < s+n){
                sum+= elements[(e+ n)%n];
                set.add(sum);
                e++;
            }
            sum= 0;
        }
        return set.size();
       
    }
}