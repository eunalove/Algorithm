import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        Map<Character, Integer> map= new HashMap<>();
        
        for(int i=0; i<skill.length(); i++)
            map.put(skill.charAt(i), i+1);
        
        int ans= 0;
        
        for(String skils: skill_trees){
            boolean flag= false;
            
            int ex= 0;
            for(int i=0; i<skils.length(); i++){
                char cur= skils.charAt(i);
                if(map.containsKey(cur)){
                    if(map.get(cur) != ex+1) flag= true;
                    ex= map.get(cur);
                }
                
            }
            if(!flag) ans++;
            
        }
        
        return ans;
        
    }
}