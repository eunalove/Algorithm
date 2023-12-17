import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
       
        Set<Integer> set= new HashSet();
        
        int sum= 0;
        int cnt= elements.length;
        //연속부분수열은 최대 elemenst의 길이만큼만 돈다.
        for(int i=1; i<elements.length+1; i++){ //1-elemenst의 길이만큼 돈다
            //1, 1 1 4 7 9
            //2, 1 1, 1 4, 4 7, 7 9, 9 1
            int j=-1;
            int tmp= i;
            for(int k=0; k<cnt; k++){
            	sum= 0;
            	for(int l=tmp; l>0; l--) {
            		sum+= elements[(j+l)%elements.length];
            	}
                set.add(sum);
                j+=1;
                
            }
            }
         answer= set.size();
        return answer;
        
       
    }
}