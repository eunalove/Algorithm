import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int ans = 1;
        
        Map<String, Integer> map= new HashMap();
        
        for(String[] cloth: clothes)
            map.put(cloth[1], map.getOrDefault(cloth[1], 1) +1);
            
        for(String key: map.keySet()){
            ans *=  map.get(key);
        }
            
        return ans -1;
    }
}