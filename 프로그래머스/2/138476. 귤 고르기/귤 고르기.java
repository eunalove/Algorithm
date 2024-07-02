import java.util.*;

class Solution {
    public int solution(int k, int[] tan) {
        
        HashMap<Integer, Integer> map= new HashMap<>();
        
        for(int t: tan)
            map.put(t, map.getOrDefault(t, 0) +1);
        
        ArrayList<Integer> list= new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int ans= 0; int sum= 0;
        for(int i=0; i<list.size(); i++){
            ans++;
            sum+= list.get(i);
            if(sum >= k) break;
            
        }
            
        return ans;
        
    }
}