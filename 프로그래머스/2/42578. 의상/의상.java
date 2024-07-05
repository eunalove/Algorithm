import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int ans = 1;
        int n= clothes.length;
        Map<String, Integer> map= new HashMap<>();
        
        for(int i=0; i<n; i++)
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) +1);
        
        for(String key: map.keySet()){
              ans *= map.get(key)+1;
        }
          
        
        return ans -1;
        
    }
}
