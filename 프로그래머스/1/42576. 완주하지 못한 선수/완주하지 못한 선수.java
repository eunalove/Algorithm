import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String ans = "";
        
         Map<String, Integer> map= new HashMap();
        
        for(String parti: participant)
            map.put(parti, map.getOrDefault(parti, 0)+1);
        
        for(String com: completion){
            if(map.get(com) > 1)
                map.put(com, map.get(com)-1);
            else map.remove(com);
        
        }
        
        for(String s: map.keySet())
            ans= s;
        
        return ans;
    }
}